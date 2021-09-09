package com.hai.code.netty.client;

import com.alibaba.fastjson.JSON;
import com.hai.code.netty.dto.MyTestRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @author admin_z by 2021/9/8
 * @ClassName SubReqClientHandler
 */
public class SubReqClientHandler2 extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("client out:" + JSON.toJSONString(msg));
//        ctx.channel().writeAndFlush("from client:" + LocalDateTime.now());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.channel().writeAndFlush("来自于客户端的问候");
        super.channelActive(ctx);
    }



}
