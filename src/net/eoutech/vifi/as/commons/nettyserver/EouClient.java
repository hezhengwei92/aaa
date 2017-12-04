package net.eoutech.vifi.as.commons.nettyserver;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import net.eoutech.vifi.as.commons.utils.ConfigUtils;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.commons.utils.StaticMsg;

public class EouClient {
    private static ConfigUtils configUtils = ConfigUtils.getInstance();
    //    private static Bootstrap bootstrap;
//    private static EventLoopGroup worker;
//
//    static {
//        try {
//            // 服务类
//            bootstrap = new Bootstrap();
//
//            // worker
//            worker = new NioEventLoopGroup(4, new DefaultThreadFactory("client", true));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            LogUtils.info("EouClient static Exception " + e.getMessage());
//        }
//    }

    public static Bootstrap bootstrap = getBootstrap();

    /**
     * 初始化Bootstrap
     */
    public static final Bootstrap getBootstrap() {
        EventLoopGroup worker = new NioEventLoopGroup(4, new DefaultThreadFactory("client", true));
        // 服务类
        Bootstrap bootstrap = new Bootstrap();
        // 设置线程池
        bootstrap.group(worker);
        // 设置socket工厂
        bootstrap.channel(NioSocketChannel.class);

        // 设置管道
        bootstrap.handler(new EouChannelInitializer());
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        return bootstrap;
    }


    public static Channel run(String vid) {
        String ip = configUtils.getCfgStr("server.test.addr");
        Integer port = configUtils.getCfgInt("server.test.port");
        Channel channel = null;
        try {

            ChannelFuture connect = bootstrap.connect(ip, port).sync();

            if (connect.isSuccess()) {
                LogUtils.info("成功连上了WS服务");
                channel = connect.channel();
                StaticMsg.getVid2Virtual().put(vid, connect.channel());
                StaticMsg.getVirtual2Vid().put(connect.channel(), vid);
            }
//            connect.addListener(new ChannelFutureListener() {
//                @Override
//                public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                    //信息完全传递成功之后才会退出虚拟客户端
//                    if (channelFuture.isDone() && channelFuture.isSuccess()) {
//                        LogUtils.info("数据传递成功Client");
//                    }
//                }
//            });

        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.info("连接" + ip + ":" + port + "失败");
            LogUtils.info("EouClient run Exception " + e.getMessage());
//        } finally {
//            worker.shutdownGracefully();
//            LogUtils.info("优雅的释放客户端");
        }
        return channel;
    }
}
