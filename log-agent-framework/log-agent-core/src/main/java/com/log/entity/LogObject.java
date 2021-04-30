package com.log.entity;


import com.alibaba.fastjson.JSONObject;
import com.log.enums.TypeEnum;

/**
 * @Description Log 实体对象
 * @Author ankangqi
 * @Date 2020/12/12 4:38 下午
 **/
public class LogObject {


    // private  Long traceId;
    private String type = TypeEnum.Normal.getDesc();

    private HttpRequest httpRequest;
    private Method method;
    private JSONObject tempDate;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    public Long getTraceId() {
//        return traceId;
//    }
//
//    public void setTraceId(Long traceId) {
//        this.traceId = traceId;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHttpRequest(HttpRequest httpRequesT) {
        this.httpRequest = httpRequesT;
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public Method getMethod() {
        return method;
    }

    public LogObject setMethod(Method method) {
        this.method = method;
        return this;
    }

    public JSONObject getTempDate() {
        return tempDate;
    }

    public void setTempDate(JSONObject tempDate) {
        this.tempDate = tempDate;
    }

    public String getLogJSON() {
        JSONObject resultJson = new JSONObject();
        //  resultJson.put("traceId",traceId);
        resultJson.put("type", type);
        resultJson.put("Request", httpRequest);
        resultJson.put("method", method);
        resultJson.put("msg", msg);
        return resultJson.toJSONString();
    }

    //    public void setLogObject(Long traceId, String type, Map<String, Object> request, Map<String, Object> method) {
//        this.traceId = traceId;
//        this.type = type;
//        this.request = request;
//        this.method = method;
//    }
//


}

  