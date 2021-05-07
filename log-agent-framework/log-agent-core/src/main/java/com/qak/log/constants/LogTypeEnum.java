package com.qak.log.constants;

public enum LogTypeEnum {

    SERVLET(0, "Servlet: Http请求"),
    HTTPCLIENT(1, "Httpclient: Http请求"),
    ASYNC(2, "Async: 异步请求"),
    DNS(3, "Dns: DNS的请求"),
    CUSTOM(4,"Custom: 通用的方法");


    private Integer value;
    private String desc;


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    LogTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
