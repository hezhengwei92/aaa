package net.eoutech.vifi.as.commons.nettyserver;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;
import net.eoutech.vifi.as.commons.utils.LogUtils;

import java.nio.CharBuffer;
import java.util.List;

/**
 * Created by WangYang on 2017/3/8 0008.
 */
public class EouMsgEncoder extends MessageToMessageEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object obj, List<Object> list) throws Exception {
        LogUtils.info("=====================ENCODER===========================");
        try {
//            //定义buffer的缓存空间大小
//            ByteBuffer buffer = ByteBuffer.allocate(1024);
//            //存放帧头
//            buffer.put(eouData.getHead().getBytes());
//            //存放通信主体
//            buffer.put(eouData.getMessage(eouData.getSender(), eouData.getReceiver()));
//            //存放循环码
//            buffer.put(eouData.getCircle());
//            //存放数据长度
//            buffer.putShort(eouData.getLength());
//            //存放包个数
//            byte pkgNum = eouData.getPkgNum();
//            buffer.put(pkgNum);
//            for (int i = 0; i < pkgNum; i++) {
//                //存放单包长度+存放动作标识+存放内容
//                buffer.put(eouData.getMsgList().get(i).createByte());
//            }
//            //存放CRC的计算值
//            buffer.putShort(eouData.getCrc());
//            //存放帧尾
//            buffer.put(eouData.getEnd().getBytes());

//            buffer.flip();
//            byteBuf.writeBytes(buffer);
//            list.add(buffer);
            if (obj instanceof EouData) {
                /*ByteBuf buf = ctx.alloc().buffer();
                EouData data = (EouData) obj;
                buf.writeBytes(EouData.getHead().getBytes());
                buf.writeByte(data.getMessage(data.getSender(), data.getReceiver()));
                buf.writeByte(data.getCircle());
                buf.writeShort(data.getLength());
                buf.writeByte(data.getPkgNum());
                for (int i = 0; i < data.getPkgNum(); i++) {
                    // 存放单包长度+存放动作标识+存放内容
                    buf.writeBytes(data.getMsgList().get(i).createByte());
                }
                buf.writeShort(data.getCrc());
                buf.writeBytes(EouData.getEnd().getBytes());*/
                ByteBuf buffer = ctx.alloc().buffer();
                EouData data = (EouData) obj;
                int length = data.getLength() + 14;
                byte[] array = new byte[length];
                byte[] head = EouData.getHead().getBytes();
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
                byte[] end = EouData.getEnd().getBytes();
                for (int i = 0; i < 4; i++) {
                    array[length + i - 4] = end[i];
                }
//				list.add(ByteBufUtil.readBytes(ctx.alloc(), buf, buf.writerIndex()));
                buffer.writeBytes(array);
                list.add(buffer);
                LogUtils.info("编码成功");
            } else {
                LogUtils.info("编码失败");
                CharSequence msg = "FAILED";
                list.add(ByteBufUtil.encodeString(ctx.alloc(),
                        CharBuffer.wrap(msg), CharsetUtil.ISO_8859_1));
            }
            LogUtils.info("Encode response message OK ");
        } catch (Exception e) {
            LogUtils.info("Encode message Exception:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
