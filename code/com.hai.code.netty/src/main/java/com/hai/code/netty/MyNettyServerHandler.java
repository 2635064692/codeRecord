package com.hai.code.netty;

import com.alibaba.fastjson.JSON;
import com.hai.code.netty.dto.MyTestRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author admin_z by 2021/9/8
 * @ClassName MyNettyServerHandler
 */
public class MyNettyServerHandler extends SimpleChannelInboundHandler<MyTestRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyTestRequest msg) throws Exception {
        System.out.println(JSON.toJSONString(msg));
    }
}
