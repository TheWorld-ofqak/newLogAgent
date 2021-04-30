package com.log.utils;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Description aop方法的工具类
 * @Author ankangqi
 * @Date 2020/12/15 8:50 下午
 **/

public class MethodUtils {

    public static String getSignature(Method method) {

        return method == null ? "NULL" : method.getDeclaringClass().getSimpleName() + "." + method.getName();
    }

    public static String getArgs(Object[] args) {

        if (args == null) {
            return "NULL";
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                continue;
            }
            Class argumentClazz = args[i].getClass();
            if (ServletRequest.class.isAssignableFrom(argumentClazz)) {
                continue;
            }
            if (ServletResponse.class.isAssignableFrom(argumentClazz)) {
                continue;
            }
            result.add(JSONObject.toJSONString(args[i]));
        }

        return JSONObject.toJSONString(result);


    }



}
