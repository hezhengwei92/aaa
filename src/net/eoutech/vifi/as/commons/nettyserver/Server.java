package net.eoutech.vifi.as.commons.nettyserver;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import net.eoutech.vifi.as.commons.utils.LogUtils;

import java.net.InetSocketAddress;

/**
 * netty服务端
 *
 * @author -WangY-
 */
public class Server {

    //boss线程监听端口，worker线程负责数据读写
    private static final EventLoopGroup boss = new NioEventLoopGroup(2, new DefaultThreadFactory("serverBoss", true));
    private static final EventLoopGroup worker = new NioEventLoopGroup(4, new DefaultThreadFactory("serverWorker", true));

    public static int createServer(int port) {

        //服务类
        ServerBootstrap bootstrap = new ServerBootstrap();

        try {
            // 设置循环线程组事例
            bootstrap.group(boss, worker);

            // 设置channel工厂
            bootstrap.channel(NioServerSocketChannel.class);

            // 设置管道
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
//					ch.pipeline().addLast(new EouMsgDecoder(65536,6,2,14,0));
//					ch.pipeline().addLast(new IdleStateHandler(120,120,0));
                    ch.pipeline().addLast(new EouSecDecoder());
//					ch.pipeline().addLast(new EouMsgEncoder());
                    ch.pipeline().addLast(new EouNewMsgEncoder());
                    ch.pipeline().addLast(new EouMsgServerHandler());
                }
            });

            bootstrap.option(ChannelOption.SO_BACKLOG, 4096);// 链接缓冲池队列大小
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE,true);//子连接保持连接

            // 绑定端口
//			bootstrap.bind(10102).sync();
            ChannelFuture future = bootstrap.bind(new InetSocketAddress(9008)).sync();
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    //信息完全传递成功之后才会退出虚拟客户端
                    if (channelFuture.isDone() && channelFuture.isSuccess()) {
                        LogUtils.info("数据传递成功Server");
                    }
                }
            });
            System.out.println("Server Start!!!");
            LogUtils.info("Server Start!!!");
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
//        } finally {
//            // 优雅的释放线程资源，并关闭服务器
//            boss.shutdownGracefully();
//            worker.shutdownGracefully();
//            LogUtils.info("优雅的释放服务端");
        }
    }
}

