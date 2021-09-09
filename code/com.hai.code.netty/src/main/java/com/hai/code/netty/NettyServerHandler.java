package com.hai.code.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.FileRegion;

import java.nio.charset.StandardCharsets;

public class NettyServerHandler {


    /**
     *
     * @Title : filter
     * @Type : FilterStr
     * @date : 2014年3月12日 下午9:17:22
     * @Description : 过滤出字母、数字和中文
     * @param character
     * @return
     */
    public static String filter(String character)
    {
        character = character.replaceAll("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]", "");
        return character;
    }

    public static void main(String[] args) {
        String s = "犯得上发11";
        byte[] msg = s.getBytes(StandardCharsets.UTF_8);

        ByteBuf buf = Unpooled.wrappedBuffer(msg);
        int i = buf.readableBytes();
    }

    /**
     *
     * @Title : filterNumber
     * @Type : FilterStr
     * @date : 2014年3月12日 下午7:23:03
     * @Description : 过滤出数字
     * @param number
     * @return
     */
    public static String filterNumber(String number)
    {
        number = number.replaceAll("[^(0-9)]", "");
        return number;
    }

    /**
     *
     * @Title : filterAlphabet
     * @Type : FilterStr
     * @date : 2014年3月12日 下午7:28:54
     * @Description : 过滤出字母
     * @param alph
     * @return
     */
    public static String filterAlphabet(String alph)
    {
        alph = alph.replaceAll("[^(A-Za-z)]", "");
        return alph;
    }

    /**
     *
     * @Title : filterChinese
     * @Type : FilterStr
     * @date : 2014年3月12日 下午9:12:37
     * @Description : 过滤出中文
     * @param chin
     * @return
     */
    public static String filterChinese(String chin)
    {
        chin = chin.replaceAll("[^(\\u4e00-\\u9fa5)]", "");
        return chin;
    }



}
