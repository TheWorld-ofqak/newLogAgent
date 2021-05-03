package com.qak.log.entity;


import java.util.Map;

/**
 * @Description httpRequest 请求实体
 * @Author ankangqi
 * @Date 2020/12/12 6:49 下午
 **/

public class HttpRequest {


    private String url;
    private Map<String, String> header;
    private Map<String, String> params;

    private String responseBody;

    public HttpRequest(String url, Map<String, String> header) {
        this.header = header;
        this.url = url;
    }

    public HttpRequest(String url, Map<String, String> header, Map<String, String> params) {
        this.header = header;
        this.url = url;
        this.params = params;
    }

    public HttpRequest() {

    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", header=" + header +
                ", params=" + params +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
}
