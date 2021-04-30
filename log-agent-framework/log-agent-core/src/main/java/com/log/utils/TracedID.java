package com.log.utils;


import java.util.UUID;

/**
 * @Description 请描述类的业务用途
 * @Author ankangqi
 * @Date 2020/12/14 4:57 下午
 **/

public class TracedID {


    public static String getTracedId() {
        return UUID.randomUUID().toString().substring(2, 14);
    }


}
