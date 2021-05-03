package com.qak.log.hooks;


import com.qak.log.constants.HookTypeEnum;

import com.qak.log.core.LogObjectProxy;
import com.qak.log.Logger;
import com.qak.log.utils.MdcUtils;
import io.promagent.annotations.*;
import com.qak.log.utils.HttpRequestUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.qak.log.constants.MethodSignConstants.*;

@Hook(instruments = {
        "javax.servlet.Servlet",
        "javax.servlet.Filter"
})
public class HttpServletHook {

    @Before(method = {"service"})
    public void serviceBefore(ServletRequest request, ServletResponse response) {

        doBefore(request, response);
    }

    @Before(method = {"doFilter"})
    public void doFilterBefore(ServletRequest request, ServletResponse response, FilterChain chain) {
        doBefore(request, response);
    }

    @After(method = {"service"})
    public void serviceAfter(ServletRequest request, ServletResponse response, @Returned Object returned , @Thrown Throwable t) {
        doAfter(request, response,returned ,t, HttpServletSign);
    }

    @After(method = {"doFilter"})
    public void serviceAfter(ServletRequest request, ServletResponse response, FilterChain chain, @Returned Object returned ,@Thrown Throwable t) {
        doAfter(request, response, returned,t, FilterSign);
    }


    public void doBefore(ServletRequest httpRequest, ServletResponse httpResponse) {

        try {
           if(HttpRequestUtils.isHttpServlet(httpRequest, httpResponse)){

               HttpServletRequest request = (HttpServletRequest) httpRequest;
               MdcUtils.setLogId(request.getHeader(TraceId));
               long startTime = System.currentTimeMillis();

               LogObjectProxy.getTempDate().put(RequestTimeStamp,startTime);
               LogObjectProxy.setRequest(request);
           }
        } catch (Throwable e) {
            Logger.error(e);
        }
    }


    public void doAfter(ServletRequest httpRequest, ServletResponse httpResponse ,Object returned ,Throwable t, String signature) {


        try {
            if(HttpRequestUtils.isHttpServlet(httpRequest, httpResponse)){
                long endTime = System.currentTimeMillis();
                long execTime = endTime - LogObjectProxy.getTempDate().getLongValue(RequestTimeStamp);

                HttpServletRequest request = (HttpServletRequest) httpRequest;
                HttpServletResponse response =   (HttpServletResponse)httpResponse;

                LogObjectProxy.setRequest(request);
                LogObjectProxy.setMethod(execTime, t, response,signature,null,returned, HookTypeEnum.SERVLET.name());

                LogObjectProxy.doLog();
                LogObjectProxy.clean();
            }
        } catch (Exception e) {
            Logger.error(e);
        }
    }


}
