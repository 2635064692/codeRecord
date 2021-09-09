package com.hai.code.netty.server;

import com.alibaba.fastjson.JSON;
import com.hai.code.netty.dto.MyTestRequest;
import io.netty.channel.*;

import java.util.UUID;

/**
 * @author admin_z by 2021/9/8
 * @ClassName SubReqServerHandler
 */
public class SubReqServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "," + msg );
        ctx.channel().writeAndFlush(new MyTestRequest("from server:" + UUID.randomUUID().toString()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();  //如果出现异常，就将连接关闭掉
    }
}
