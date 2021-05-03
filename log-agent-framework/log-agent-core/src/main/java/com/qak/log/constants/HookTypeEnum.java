package com.qak.log.constants;

public enum HookTypeEnum {

    SERVLET(0, "Servlet: Http请求"),
    HTTPCLIENT(1, "Httpclient: Http请求"),
    ASYNC(2, "异步请求"),
    DNS(3, "DNS的请求"),
    CUSTOM(4,"通用的请求");


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

    HookTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
