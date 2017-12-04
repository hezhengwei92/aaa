package net.eoutech.vifi.as.commons.nettyserver;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class EouChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new EouSecDecoder());
        ch.pipeline().addLast(new EouClientEncoder());
        ch.pipeline().addLast(new ClientHandler());
    }

}
