package net.eoutech.vifi.as.commons.nettyserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.commons.utils.StaticMsg;

import java.text.SimpleDateFormat;

public class ClientHandler extends SimpleChannelInboundHandler<String> {
//    public ClientHandler(String vid, EouData data) {
//        this.data = data;
//        this.vid = vid;
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String e)
            throws Exception {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LogUtils.info("CHANNEL ACTIVE");
//        LogUtils.info("CHANNEL ACTIVE" + this.data.toString());
//        LogUtils.info("vid="+vid+"---通道："+ctx.channel().toString());
//        StaticMsg.getVid2Virtual().put(vid,ctx.channel());
//        StaticMsg.getVirtual2Vid().put(ctx.channel(),vid);
////		AppendToFile.appendMethodA("E:/StaticMap.txt", format.format(new Date()) + "----->" + ctx.channel().toString()+"=====>" + StaticMsg.getChannelMap().get(ctx.channel()).toString() + "\n");
//        ctx.writeAndFlush(this.data);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LogUtils.info(ctx.channel() + "与WS服务端断开连接");
        ctx.channel().close();
        if (StaticMsg.getVirtual2Vid().get(ctx.channel()) != null){
            LogUtils.info("虚拟通道和设备号映射检查完成");
            String vid = StaticMsg.getVirtual2Vid().get(ctx.channel());
            if (StaticMsg.getVid2Virtual().get(vid) != null){
                LogUtils.info("设备号和虚拟通道映射检查完成，开始移除映射");
                StaticMsg.getVid2Virtual().remove(vid);
                StaticMsg.getVirtual2Vid().remove(ctx.channel());
            }
        }
        //清除已存在的错误映射通道
    }

}
