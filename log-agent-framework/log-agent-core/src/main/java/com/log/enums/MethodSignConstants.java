package io.promagent.enums;

/**
 * @description: 方法签名的枚举类
 * @author: qiankang
 * @time: 2021/4/17 14:21
 */


public interface   MethodSignConstants {

    String HandlerInterceptorSign = "HandlerInterceptor.preHandle";
    String FilterSign = "Filter.doFilter";
    String HttpServletSign = "HttpServlet.service";
    String RequestTimeStamp = "RequestTimeStamp";


}
