package io.promagent.entity;


import java.util.Arrays;

/**
 * @Description 类型方法
 * @Author ankangqi
 * @Date 2020/12/12 6:54 下午
 **/

public class Method {

    //方法名称
    private String methodSignature;
    //执行结果
    private Object returnResult;
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


    public Long getExecTime() {
        return execTime;
    }

    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }

    public Object getReturnResult() {
        return returnResult;
    }

    public void setReturnResult(Object returnResult) {
        this.returnResult = returnResult;
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
                ", returnResult=" + returnResult +
                ", methodThrow=" + methodThrow +
                ", execTime=" + execTime +
                ", type='" + type + '\'' +
                '}';
    }
}
