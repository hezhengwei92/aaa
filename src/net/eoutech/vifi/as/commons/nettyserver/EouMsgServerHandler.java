package net.eoutech.vifi.as.commons.nettyserver;

import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.eoutech.vifi.as.commons.base.VaMsgResp;
import net.eoutech.vifi.as.commons.base.VaReqMsgFactory;
import net.eoutech.vifi.as.commons.entity.TbSimPDev;
import net.eoutech.vifi.as.commons.enums.VaMsgType;
import net.eoutech.vifi.as.commons.nettyserver.entity.CardMsg;
import net.eoutech.vifi.as.commons.nettyserver.entity.MsgContent;
import net.eoutech.vifi.as.commons.nettyserver.utils.OrderUtil;
import net.eoutech.vifi.as.commons.utils.CommonUtils;
import net.eoutech.vifi.as.commons.utils.DataProcess;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.commons.utils.StaticMsg;
import net.eoutech.vifi.as.main.VaAccountingServer;
import net.eoutech.vifi.as.vsw.service.utils.VaSimPDeviceService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class EouMsgServerHandler extends SimpleChannelInboundHandler<Object> {
    private static final byte[] bytes = new byte[]{0, 1, 2, 4, 8};// 0 1 2 3 4
    private VaAccountingServer server = VaAccountingServer.getInstance();
    private VaSimPDeviceService simPDeviceService = VaSimPDeviceService.getInstance();

    private static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

    protected void channelRead0(ChannelHandlerContext ctx, Object obj) throws Exception {
        LogUtils.info("收到完整的数据了，开始处理");
        if (!(obj instanceof EouData)) {
            LogUtils.info("NOT EouData instance!");
        } else {
            EouData req = (EouData) obj;
            if (req.getSender() == 1 && req.getReceiver() == 8) {//设备发给卡池，从WS服务器获取到的信息
                //根据包个数来获取对应的数据
                EouData data = new EouData();
                List<MsgContent> list = new ArrayList<>();

                data.setSender(req.getSender());
                data.setReceiver(req.getReceiver());
                data.setCircle(req.getCircle());//循环码加一
                data.setPkgNum(req.getPkgNum());

                int length = 0;
                int action = 0;
                //分别获取内容
                for (int i = 0; i < req.getPkgNum(); i++) {
                    //获取包序列内容
                    MsgContent reqContent = req.getMsgList().get(i);
                    MsgContent respContent = new MsgContent();
                    int choose = reqContent.getAction() & 0xFF;
                    //处理数据
                    switch (choose) {
                        case 0xA3:
                        case 0x93:
                        case 0x83:
                        case 0x03://WS处理过的消息，不需要处理，直接过度传递
                            byte[] oldContent = reqContent.getContent();//接收到的数据
                            respContent.setPkgLen((short) (oldContent.length + 1));
                            respContent.setAction(reqContent.getAction());
                            respContent.setContent(oldContent);
                            list.add(respContent);
                            action = 3;
                            break;
                        case 0x05://WS获取ATR之后，发送的消息，用来打通卡池的连接
                            String content = "";
                            byte[] contents = reqContent.getContent();
                            for (int j = 0; j < contents.length; j++) {
                                content += (char) contents[j];
                            }
                            CardMsg msg = JSONObject.parseObject(content, CardMsg.class);
                            String addrPort = "/" + msg.getIpaddr() + ":" + msg.getPort();
                            //存储虚拟客户端通道和卡池连接通道的映射
                            LogUtils.info("存储虚拟客户端通道和卡池连接通道的映射" + ctx.channel() + "----" + StaticMsg.getIpPort2Pipe().get(addrPort));
                            StaticMsg.getVirtual2Pipe().put(ctx.channel(), StaticMsg.getIpPort2Pipe().get(addrPort));

                            String chaId = StaticMsg.getIpPort2Pipe().get(addrPort).id().toString();//卡池对应通道的id
                            LogUtils.info("&&&&&&&&&&&&&&&&&&---" + chaId);
                            System.out.println("&&&&&&&&&&&&&&&&&&---" + chaId);

                            String vid = msg.getVid();
                            String slotNum = chaId + msg.getSlotNum();
                            LogUtils.info("channel slotNum:" + slotNum);
                            //存储卡池卡槽号和设备号的映射
                            StaticMsg.getSlot2Vid().put(slotNum, vid);
                            //存储虚拟通道号和设备号的映射
                            StaticMsg.getVirtual2Vid().put(ctx.channel(), vid);

                            LogUtils.info("卡槽号：" + slotNum.substring(8, slotNum.length()) + " , 设备号：" + vid);

                            //存储设备号和卡槽号的映射
                            StaticMsg.getVid2Slot().put(vid, slotNum);

                            //清除已存在的错误映射通道
//                            if (StaticMsg.getVid2Virtual().get(vid) != null) {
//                                LogUtils.info("关闭已经失效的通道映射");
//                                StaticMsg.getVid2Virtual().get(vid).close();
//                                StaticMsg.getVid2Virtual().remove(vid);//移除映射关系
//                            }
                            if (StaticMsg.getVid2Virtual().get(vid) == null) {
                                LogUtils.info("建立通信虚拟通道");
//                                EouClient.run(vid, OrderUtil.PassChannel(data.getCircle()));
                                Channel channel = EouClient.run(vid);
                                if (channel != null){
                                    channel.writeAndFlush(OrderUtil.PassChannel(data.getCircle()));
                                }else {
                                    LogUtils.info("--获取channel失败--");
                                }
                            }
                            break;
                        case 0x1F:
                            byte[] oldContents = reqContent.getContent();
                            byte[] newContents = new byte[1];
                            String vids = "";
                            for (int j = 0; j < oldContents.length; j++) {
                                vids += (char) oldContents[i];
                            }
                            int slotNumb = Integer.parseInt(StaticMsg.getVid2Slot().get(vids).substring(8, vids.length()));
                            newContents[0] = (byte) slotNumb;
                            respContent.setAction(reqContent.getAction());
                            respContent.setPkgLen((short) (newContents.length + 1));
                            respContent.setContent(newContents);
                            list.add(respContent);
                            action = 3;
                            break;
                        default:
                            break;
                    }
                    if (reqContent.getAction() != 5) {
                        length += respContent.createByte().length;
                    }
                }
                if (action == 3) {//特定命令才给卡池发消息
                    //计算内容的长度
                    data.setLength((short) (length + 1));
                    data.setMsgList(list);
                    data.setCrc(EouData.creatCRC(data));
                    Channel channel = StaticMsg.getVirtual2Pipe().get(ctx.channel());
                    LogUtils.info("回复给卡池信息");
                    LogUtils.info(ctx.channel() + "-------" + channel.toString());
                    ChannelFuture result = channel.writeAndFlush(data);
                    if (result.isSuccess()) {
                        LogUtils.info("isSuccess");
                    }
                    if (result.isDone()) {
                        LogUtils.info("isDone");
                    }
                    if (result.isVoid()) {
                        LogUtils.info("isVoid");
                    }
                    if (result.isCancelled()) {
                        LogUtils.info("isCancelled");
                    }
                    if (result.isCancellable()) {
                        LogUtils.info("isCancellable");
                    }
                }
            } else if (req.getSender() == 8 && req.getReceiver() == 1) {//卡池发给设备
                //根据包个数来获取对应的数据
                EouData data = new EouData();
                List<MsgContent> list = new ArrayList<>();

                data.setSender(req.getSender());
                data.setReceiver(req.getReceiver());
                data.setCircle(req.getCircle());
                data.setPkgNum(req.getPkgNum());
                int length = 0;
                String vid = "";
                //分别获取内容
                for (int i = 0; i < req.getPkgNum(); i++) {
                    //获取包序列内容
                    MsgContent reqContent = req.getMsgList().get(i);
                    MsgContent respContent = new MsgContent();

                    //处理数据
                    switch (reqContent.getAction()) {
                        case 0x04://该内容是卡池中的卡发给设备的，需要在其中把设备号添加进去进行处理
                            byte[] oldContents = reqContent.getContent();
                            LogUtils.info("---------------------" + oldContents[0]);

                            String chaId = ctx.channel().id().toString();
                            LogUtils.info("^^^^^^^^^^^^^^^^^" + chaId + "----------" + DataProcess.byteToInt(oldContents[0]));
                            vid = StaticMsg.getSlot2Vid().get(chaId + DataProcess.byteToInt(oldContents[0]));
                            LogUtils.info("vid=" + vid);

                            byte[] vidByte = vid.getBytes();
                            int reLen = vidByte.length;

                            byte[] newContents = new byte[oldContents.length + vidByte.length];

                            //设备号的长度
                            newContents[0] = (byte) reLen;

                            //添加设备号
                            for (int j = 0; j < reLen; j++) {
                                newContents[j + 1] = vidByte[j];
                            }

                            //添加去除卡槽编号的具体内容
                            for (int j = 0; j < oldContents.length - 1; j++) {
                                newContents[j + reLen + 1] = oldContents[j + 1];
                            }

                            respContent.setAction(reqContent.getAction());
                            respContent.setPkgLen((short) (newContents.length + 1));
                            respContent.setContent(newContents);
                            list.add(respContent);
                            break;
                        default:
                            break;
                    }
                    length += respContent.createByte().length;
                }
                //计算内容的长度
                data.setLength((short) (length + 1));
                data.setMsgList(list);
                data.setCrc(EouData.creatCRC(data));
                LogUtils.info("EouData装配完成");

                if (StaticMsg.getVid2Virtual().get(vid) == null) {
                    LogUtils.info("新建虚拟通道");
//                    EouClient.run(vid, data);
                    Channel channel = EouClient.run(vid);
                    if (channel != null){
                        channel.writeAndFlush(data);
                    }else {
                        LogUtils.info("&&获取channel失败&&");
                    }
                } else {
                    LogUtils.info("使用已存在的虚拟通道");
                    LogUtils.info("vid=" + vid + "---通道：" + StaticMsg.getVid2Virtual().get(vid).toString());
                    StaticMsg.getVid2Virtual().get(vid).writeAndFlush(data);
                }
            } else if (req.getSender() == 8 && req.getReceiver() == 4) {//设备发给云端，入库，更新
                StaticMsg.getIpPort2Pipe().put(ctx.channel().remoteAddress().toString(), ctx.channel());
                for (int i = 0; i < req.getPkgNum(); i++) {
                    MsgContent msg = req.getMsgList().get(i);
                    int action = DataProcess.byteToInt(msg.getAction());
                    if (action == 1) {//该内容是json格式的字符串，需要解析
                        byte[] bytes = msg.getContent();

                        String messageType = "";
                        for (int j = 0; j < bytes.length; j++) {
                            messageType += (char) bytes[j];
                        }

                        VaMsgType msgType = VaReqMsgFactory.getInstance().parseMsgType(messageType);

                        String remoteIpAndPort = ctx.channel().remoteAddress().toString();
                        String serveIpAndPort = ctx.channel().localAddress().toString();

                        String message;
                        String newMessage = "";
                        if (msgType.toString().equals("SPUBLISH")) {
                            message = CommonUtils.getMessage(bytes);
                            newMessage = CommonUtils.getMessageStr(message, serveIpAndPort, remoteIpAndPort);
                        } else if (msgType.toString().equals("GSREG")) {
                            newMessage = CommonUtils.getMessageStr(messageType, serveIpAndPort, remoteIpAndPort);
                        } else if (msgType.toString().equals("VUPDATE")) {
                            newMessage = messageType;
                        } else {
                            newMessage = CommonUtils.getMessage(bytes);
                        }

                        LogUtils.info("-- newMessage -->" + newMessage);
                        System.out.println("-- newMessage -->" + newMessage);
                        //进入原来程序的执行逻辑
                        VaMsgResp resp = server.run(newMessage);

                        byte[] content = resp.toJSONString().toString().getBytes();
                        EouData respMsg = new EouData();
                        respMsg.setSender(req.getReceiver());
                        respMsg.setReceiver(req.getSender());
                        respMsg.setCircle((byte) (req.getCircle() + 1));
                        respMsg.setLength((short) (content.length + 4));
                        respMsg.setPkgNum(this.bytes[1]);
                        List<MsgContent> listContent = new ArrayList<>();
                        for (int j = 0; j < respMsg.getPkgNum(); j++) {
                            MsgContent msgContent = new MsgContent();
                            msgContent.setPkgLen((short) (content.length + 1));
                            msgContent.setAction(this.bytes[1]);
                            msgContent.setContent(content);
                            listContent.add(msgContent);
                        }
                        respMsg.setMsgList(listContent);
                        respMsg.setCrc(EouData.creatCRC(respMsg));
//                        ctx.writeAndFlush(respMsg);//可以回消息给卡池，也可以不回
                    } else if (action == 0) {
                        ctx.writeAndFlush(nullData());
                    } else if (action == 0x12) {
                        LogUtils.info("出故障了");
                        byte[] malfunction = msg.getContent();
                        LogUtils.info("卡号：" + (malfunction[0] & 0xFF));
                        int error = malfunction[1] & 0xFF;
                        LogUtils.info("错误码：" + error);
                        //01 卡未处于工作状态(云端试图访问一张没有工作的卡)
                        //02 卡处于工作状态，但卡无数据应答(81命令超时后没读到数据)
                        //03 卡存在（但是卡的状态异常，需要重启卡）
                        if (error == 1) {
                            LogUtils.info("卡未处于工作状态(云端试图访问一张没有工作的卡)");
                        } else if (error == 2) {
                            LogUtils.info("卡处于工作状态，但卡无数据应答(81命令超时后没读到数据)");
                        } else if (error == 3) {
                            LogUtils.info("卡存在（但是卡的状态异常，需要重启卡）");
                        } else {
                            LogUtils.info("没有这个错误定义");
                        }
                    }
                }
            } else if (req.getSender() == 4 && req.getReceiver() == 4) {
                for (int i = 0; i < req.getPkgNum(); i++) {
                    MsgContent msg = req.getMsgList().get(i);
                    byte action = msg.getAction();
                    if (DataProcess.byteToInt(action) == 0x1F) {//该内容是json格式的字符串，需要解析
                        byte[] bytes = msg.getContent();

                        String vid = "";
                        for (int j = 0; j < bytes.length; j++) {
                            vid += (char) bytes[j];
                        }
                        LogUtils.info("所需处理的设备号：" + vid);
                        LogUtils.info("设备号和卡槽映射情况：" + (StaticMsg.getVid2Slot().get(vid) == null));
                        String slot = StaticMsg.getVid2Slot().get(vid);
                        LogUtils.info("所需处理的卡槽号：" + StaticMsg.getVid2Slot().get(vid).substring(8, slot.length()));
                        int slotNum = Integer.parseInt(StaticMsg.getVid2Slot().get(vid).substring(8, slot.length()));
                        LogUtils.info("待复位的卡槽：" + slotNum);

                        byte[] content = new byte[]{this.bytes[0], (byte) slotNum};
                        EouData restData = new EouData();
                        restData.setSender(this.bytes[3]);
                        restData.setReceiver(this.bytes[4]);
                        restData.setCircle(req.getCircle());
                        restData.setLength((short) (content.length + 4));
                        restData.setPkgNum(this.bytes[1]);
                        List<MsgContent> listContent = new ArrayList<>();
                        for (int j = 0; j < restData.getPkgNum(); j++) {
                            MsgContent msgContent = new MsgContent();
                            msgContent.setPkgLen((short) (content.length + 1));
                            msgContent.setAction((byte) 0x1F);
                            msgContent.setContent(content);
                            listContent.add(msgContent);
                        }
                        restData.setMsgList(listContent);
                        restData.setCrc(EouData.creatCRC(restData));
                        LogUtils.info("组装复位卡数据成功");
                        LogUtils.info("虚拟通道和卡池通道映射关系：" + (StaticMsg.getVirtual2Pipe().get(ctx.channel()) == null));
                        StaticMsg.getVirtual2Pipe().get(ctx.channel()).writeAndFlush(restData);
                    }
                }
            }
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("-----channelActive-----" + ctx.channel() + "---连接成功---" + format.format(new Date()));
        LogUtils.info("连接上ctx:" + ctx.channel());
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        LogUtils.info("----------channelRegistered----------");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        LogUtils.info("----------channelUnregistered----------");
        super.channelUnregistered(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        LogUtils.info("----------handlerAdded----------");
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        LogUtils.info("----------handlerRemoved----------");
        super.handlerRemoved(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LogUtils.info(ctx.channel() + "---exceptionCaught---" + cause.getMessage() + "---" + Arrays.toString(cause.getStackTrace()));
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel() + "---断开连接---" + format.format(new Date()));
        LogUtils.info("-----channelInactive-----" + ctx.channel() + "---断开连接---" + format.format(new Date()));

        String ipPort = ctx.channel().remoteAddress().toString().replace("/", "");
        String[] address = ipPort.split(":");
        LogUtils.info(Arrays.toString(address));
        TbSimPDev simPDev = simPDeviceService.selectCardPoolByIPPort(address[0], address[1]);
        if (simPDev != null) {
            if (!(StringUtils.isNullOrEmpty(simPDev.getDevName()))) {
                simPDeviceService.resetSimPDevice(simPDev.getDevName());
            }
            LogUtils.info("发布移除队列中所有元素的命令");
            if (StaticMsg.getVid2Virtual().get("justClean") == null) {
//                EouClient.run("justClean", CleanQueue(simPDev.getKeySimPDevID()));
                Channel channel = EouClient.run("justClean");
                if (channel != null){
                    channel.writeAndFlush(CleanQueue(simPDev.getKeySimPDevID()));
                }else {
                    LogUtils.info("**获取channel失败**");
                }
            } else {
                LogUtils.info("justClean映射存在");
                StaticMsg.getVid2Virtual().get("justClean").writeAndFlush(CleanQueue(simPDev.getKeySimPDevID()));
            }
        }

        /*if (StaticMsg.getVirtual2Vid() != null){//AAA与WS连接的服务断开才进行大面积清除操作
            String vid = StaticMsg.getVirtual2Vid().get(ctx.channel());
            if (StaticMsg.getVid2Slot().get(vid) != null){
                Integer slotNum = Integer.parseInt(StaticMsg.getVid2Slot().get(vid).substring(8,vid.length()));
                if (StaticMsg.getSlot2Vid().get(slotNum) != null) {
                    StaticMsg.getSlot2Vid().remove(slotNum);
                }
            }
            if (StaticMsg.getVid2Virtual().get(vid) != null) {
                StaticMsg.getVid2Virtual().remove(vid);
            }
//            if (StaticMsg.getVid2Slot().get(vid) != null) {
//                StaticMsg.getVid2Slot().remove(vid);
//            }
            if (StaticMsg.getVirtual2Pipe().get(ctx.channel()) != null) {
                StaticMsg.getVirtual2Pipe().remove(ctx.channel());
            }
        }*/
        if (StaticMsg.getCtx2Buf().get(ctx.channel()) != null) {
            StaticMsg.getCtx2Buf().remove(ctx.channel());
        }
        ctx.channel().close();
        LogUtils.info("移除成功");
    }

    public byte[] toByte(EouData data) {
        int length = data.getLength() + 14;
        byte[] array = new byte[length];
        byte[] head = data.getHead().getBytes();
        for (int i = 0; i < 4; i++) {
            array[i] = head[i];
        }
        array[4] = data.getMessage(data.getSender(), data.getReceiver());
        array[5] = data.getCircle();
        array[6] = (byte) ((data.getLength() >> 8) & 0xFF);
        array[7] = (byte) (data.getLength() & 0xFF);
        array[8] = data.getPkgNum();
        int len = 0;
        for (int i = 0; i < data.getPkgNum(); i++) {
            byte[] content = data.getMsgList().get(i).createByte();
            for (int j = 0; j < content.length; j++) {
                array[9 + j + len] = content[j];
            }
            len += content.length;
        }
        array[length - 6] = (byte) ((data.getCrc() >> 8) & 0xFF);
        array[length - 5] = (byte) (data.getCrc() & 0xFF);
        byte[] end = data.getEnd().getBytes();
        for (int i = 0; i < 4; i++) {
            array[length + i - 4] = end[i];
        }
        return array;
    }


    public EouData nullData() {
        EouData data = new EouData();
        data.setSender((byte) 4);
        data.setReceiver((byte) 8);
        data.setCircle((byte) 0);
        data.setLength((short) 5);
        data.setPkgNum((byte) 1);
        List<MsgContent> list = new ArrayList<>();
        MsgContent content = new MsgContent();
        content.setPkgLen((short) 2);
        content.setAction((byte) 0);
        content.setContent(new byte[]{0});
        list.add(content);
        data.setMsgList(list);
        data.setCrc(EouData.creatCRC(data));
        return data;
    }

    public EouData CleanQueue(String keySimPDevID) {
        EouData data = new EouData();
        data.setSender((byte) 4);
        data.setReceiver((byte) 4);
        data.setCircle((byte) 0);
        data.setPkgNum((byte) 1);
        List<MsgContent> list = new ArrayList<>();
        MsgContent content = new MsgContent();
        content.setPkgLen((short) 3);
        content.setAction((byte) 0x10);
        byte[] keySimPDevIDs = keySimPDevID.getBytes();
        byte[] removeCon = new byte[keySimPDevIDs.length + 1];
        removeCon[0] = (byte) 0xFF;
        for (int i = 0; i < keySimPDevIDs.length; i++) {
            removeCon[i + 1] = keySimPDevIDs[i];
        }
        content.setContent(removeCon);
        content.setPkgLen((short) (removeCon.length + 1));
        data.setLength((short) (removeCon.length + 4));
        list.add(content);
        data.setMsgList(list);
        data.setCrc(EouData.creatCRC(data));
        return data;
    }
}
