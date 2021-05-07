package com.qak.log.entity;




/**
 * @Description 方法实体
 * @Author ankangqi
 * @Date 2020/12/12 6:54 下午
 **/

public class Method {

    //方法名称
    private String methodSignature;
    //方法参数
    private String methodArgs;
    //http 请求响应状态码
    private int responseStatusCode;
    //方法执行结果
    private String returned;
    //方法异常
    private Throwable methodThrow;
    //执行消耗的时间
    private Long execTime;



    public Method() {

    }


    public String getMethodSignature() {
        return methodSignature;
    }

    public void setMethodSignature(String methodSignature) {
        this.methodSignature = methodSignature;
    }

    public String getMethodArgs() {
        return methodArgs;
    }

    public void setMethodArgs(String methodArgs) {
        this.methodArgs = methodArgs;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
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

    @Override
    public String toString() {
        return "Method{" +
                "methodSignature='" + methodSignature + '\'' +
                ", methodArgs='" + methodArgs + '\'' +
                ", responseStatusCode=" + responseStatusCode +
                ", returned='" + returned + '\'' +
                ", methodThrow=" + methodThrow +
                ", execTime=" + execTime +
                '}';
    }
}
