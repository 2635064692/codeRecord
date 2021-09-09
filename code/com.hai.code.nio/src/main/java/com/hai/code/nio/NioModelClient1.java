package com.hai.code.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

/**
 * @author admin_z by 2021/9/7
 * @ClassName NioModelClient
 */
public class NioModelClient1 {

    public static void main(String[] args) {
        String s = "犯得上发11";
        byte[] msg = s.getBytes(StandardCharsets.UTF_8);

        ByteBuf buf = Unpooled.wrappedBuffer(msg);
        int i = buf.readableBytes();
    }
}
