package com.hai.code.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.itstack.naive.chat.protocol.MyTestRequest;

/**
 * @author admin_z by 2021/9/8
 * @ClassName NettyTestServer
 */
public class NettyTestClient {

    private String inetHost = "127.0.0.1";
    private int inetPort = 7397;

    public void send(){
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.AUTO_READ, true);
            b.handler(new NettyServerHandler());

            ChannelFuture channelFuture = b.connect("127.0.0.1", 8821).syncUninterruptibly();
            Channel channel = channelFuture.channel();

            channel.writeAndFlush(new MyTestRequest("1"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }





//        group.shutdownGracefully();
    }

    public static void main(String[] args) {
        new NettyTestClient().send();
    }

}
