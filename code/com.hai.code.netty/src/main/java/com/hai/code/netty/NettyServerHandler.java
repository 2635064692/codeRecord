package com.hai.code.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author admin_z by 2021/9/8
 * @ClassName NettyServerHandler
 */
public class NettyServerHandler  extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("test",new MyNettyServerHandler());
    }
}
