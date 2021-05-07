package com.qak.log.entity;


import com.alibaba.fastjson.JSONObject;
import com.qak.log.constants.LogTypeEnum;
import com.qak.log.utils.MdcUtils;

/**
 * @Description Log 实体对象
 * @Author ankangqi
 * @Date 2020/12/12 4:38 下午
 **/
public class LogObject {


    private Long traceId ;                               // 追踪id
    private String type = LogTypeEnum.CUSTOM.getDesc();  // 日志的类型
    private HttpRequest httpRequest = new HttpRequest(); // http请求对象
    private Method method = new Method();                // 方法对象
    private JSONObject tempDate  = new JSONObject();     // 用于存放临时的数据
    private String msg;                                  //




    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTraceId() {
        return traceId;
    }

    public void setTraceId(Long traceId) {
        this.traceId = traceId;
    }

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
        resultJson.put("traceId", MdcUtils.getLogId());
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

  