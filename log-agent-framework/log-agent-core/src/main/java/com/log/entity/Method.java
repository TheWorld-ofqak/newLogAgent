package com.log.entity;


import java.util.Arrays;

/**
 * @Description 类型方法
 * @Author ankangqi
 * @Date 2020/12/12 6:54 下午
 **/

public class Method {

    //方法名称
    private String methodSignature;
    //响应状态码
    private int responseStatusCode;
    //响应体
    private String responseBody;
    //方法异常
    private Throwable methodThrow;
    //执行消耗的时间
    private Long execTime;
    //方法种类
    private String type;

    public Method() {

    }


    public String getMethodSignature() {
        return methodSignature;
    }

    public void setMethodSignature(String methodSignature) {
        this.methodSignature = methodSignature;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public Long getExecTime() {
        return execTime;
    }

    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }

    public int getResponseStatusCode() {
        return responseStatusCode;
    }

    public void setResponseStatusCode(int responseStatus) {
        this.responseStatusCode = responseStatus;
    }

    public Throwable getMethodThrow() {
        return methodThrow;
    }

    public void setMethodThrow(Throwable methodThrow) {
        this.methodThrow = methodThrow;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Method{" +
                "methodSignature='" + methodSignature + '\'' +
                ", responseStatusCode=" + responseStatusCode +
                ", responseBody='" + responseBody + '\'' +
                ", methodThrow=" + methodThrow +
                ", execTime=" + execTime +
                ", type='" + type + '\'' +
                '}';
    }
}
