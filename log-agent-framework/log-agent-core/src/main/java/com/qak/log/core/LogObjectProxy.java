package com.qak.log.core;


import com.alibaba.fastjson.JSONObject;
import com.qak.log.entity.HttpRequest;
import com.qak.log.entity.LogObject;
import com.qak.log.entity.Method;
import com.qak.log.utils.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Objects;

import static com.qak.log.utils.HttpRequestUtils.getHeaders;
import static com.qak.log.utils.HttpRequestUtils.getParams;

/**
 * @Descriptio 用于要打出来日志的日志代理   日志实体类的代理类，对日志进行打印
 * @Author ankangqi
 * @Date 2020/12/15 8:35 下午
 **/
public class LogObjectProxy {


    private static final Logger logger = LoggerFactory.getLogger(LogObjectProxy.class);


    public static void setRequest(HttpServletRequest request) throws UnsupportedEncodingException {

        LogObject currLogObject = LogContext.get();
        HttpRequest httpRequest = currLogObject.getHttpRequest();

        if(Objects.isNull(httpRequest.getUrl())){ // 说明为前置aop
            String requestUrl = request.getRequestURI();
            Map<String, String> headers = getHeaders(request);
            httpRequest.setUrl(requestUrl);
            httpRequest.setHeader(headers);
        }else {
            Map<String, String> params = getParams(request);
            httpRequest.setParams(params);
        }

    }


    public static void setMethod(Long execTime, Throwable error, HttpServletResponse response, String sign,Object[] args, Object returned, String type)  {

        Method method = LogContext.get().getMethod();
        String methodArgs = MethodUtils.getArgs(args);

        int responseStatusCode = 0;
        if(Objects.nonNull(response)){
            responseStatusCode = MethodUtils.getResponseStatus(response);
        }
        //String responseBody = MethodUtils.getResponseBody(response);

        method.setMethodSignature(sign);
        method.setMethodArgs(methodArgs);
        method.setExecTime(execTime);
        method.setResponseStatusCode(responseStatusCode);
        method.setMethodThrow(error);
        method.setType(type);
    }


    public static void setTempDate(JSONObject tempObject) {

        LogObject currLogObject = LogContext.get();
        currLogObject.setTempDate(tempObject);

    }

    public static JSONObject getTempDate() {

        LogObject currLogObject = LogContext.get();
        return currLogObject.getTempDate();

    }


    public static void doLog() {

        String jsonMsg = LogContext.get().getLogJSON();

        logger.info(jsonMsg);

    }


    public static void clean() {
        LogContext.clear();
    }


    public static void error(Throwable error) {
        LogObject logObject = LogContext.get();
        logObject.setMsg(error.toString());

        logger.error(logObject.getLogJSON());
    }

}

  