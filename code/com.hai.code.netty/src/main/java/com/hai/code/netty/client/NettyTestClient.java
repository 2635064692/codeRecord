package com.hai.code.netty.client;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.hai.code.netty.dto.MyTestRequest;
import com.hai.code.netty.utils.BeanUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @author admin_z by 2021/9/8
 * @ClassName NettyTestServer
 */
public class NettyTestClient {

    public void send(){
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group);
            b.channel(NioSocketChannel.class);
//            b.option(ChannelOption.TCP_NODELAY, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ObjectDecoder(1024*1024, ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
                    ch.pipeline().addLast(new ObjectEncoder());
                    ch.pipeline().addLast(new SubReqClientHandler());
                    ch.pipeline().addLast(new SubReqClientHandler1());
                    ch.pipeline().addLast(new SubReqClientHandler2());
                }
            });
            ChannelFuture channelFuture = b.connect("192.168.1.147", 1100).sync();
            channelFuture.channel().closeFuture().sync();
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
