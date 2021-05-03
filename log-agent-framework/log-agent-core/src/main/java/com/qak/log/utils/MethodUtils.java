package com.qak.log.utils;


import com.alibaba.fastjson.JSONObject;


import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

/**
 * @Description aop方法的工具类
 * @Author ankangqi
 * @Date 2020/12/15 8:50 下午
 **/

public class MethodUtils {

    public static String getSignature(Method method) {

        return method == null ? "NULL" : method.getDeclaringClass().getSimpleName() + "." + method.getName();
    }


    public static  int getResponseStatus(ServletResponse response)  {

        HttpServletResponse httpServletResponse   = (HttpServletResponse)response;
        int status = httpServletResponse.getStatus();

        return status;
    }

    public static  String getResponseBody(ServletResponse response) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ServletResponse servletResponse = new ServletResponseWrapper(response);
        BeanUtils.copyProperties(response,servletResponse);

        int bufferSize = servletResponse.getBufferSize();
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        byte[] responseByte = new byte[bufferSize];

        outputStream.write(responseByte);
        String responseBody = Arrays.toString(responseByte);
//        PrintWriter writer = httpServletResponse.getWriter();
//        writer.write(responseBody);

        return responseBody;
    }


    public static String getArgs(Object[] args) {

        if (args == null || args.length == 0) {
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
        if (CollectionUtils.isEmpty(result)) {
            return "null";
        }

        return JSONObject.toJSONString(result);


    }



}
