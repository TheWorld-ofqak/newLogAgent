package io.promagent.enums;

public enum TypeEnum {

    Normal(0, "Http请求"),
    CREATE(1, "Httpclient构建的http请求"),
    ASYNC(2, "异步请求"),
    DNS(3, "DNS的请求");


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

    TypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
