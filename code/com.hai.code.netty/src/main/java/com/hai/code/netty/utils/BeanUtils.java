package com.hai.code.netty.utils;

import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin_z by 2021/9/8
 * @ClassName BeanUntils
 */
public class BeanUtils {

    public static List<Channel> cacheChannelList = new ArrayList<>();

    public static Channel getChannel(){
        if (cacheChannelList!=null && cacheChannelList.size() >0){
            return cacheChannelList.get(0);
        }

        return null;
    }

}
