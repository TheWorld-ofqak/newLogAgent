package io.promagent.hooks;


import io.promagent.Logger;
import io.promagent.core.LogObjectProxy;
import io.promagent.enums.TypeEnum;
import io.promagent.annotations.After;
import io.promagent.annotations.Before;
import io.promagent.annotations.Hook;
import io.promagent.annotations.Thrown;
import io.promagent.utils.HttpRequestUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import static io.promagent.enums.MethodSignConstants.*;

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
    public void serviceAfter(ServletRequest request, ServletResponse response, @Thrown Throwable t) {
        doAfter(request, response, t, HttpServletSign);
    }

    @After(method = {"doFilter"})
    public void serviceAfter(ServletRequest request, ServletResponse response, FilterChain chain, @Thrown Throwable t) {
        doAfter(request, response, t, FilterSign);
    }


    public void doBefore(ServletRequest httpRequest, ServletResponse httpResponse) {

        try {
           if(HttpRequestUtils.isHttpServlet(httpRequest, httpResponse)){
               HttpServletRequest request = (HttpServletRequest) httpRequest;

               long startTime = System.currentTimeMillis();
               LogObjectProxy.getTempDate().put(RequestTimeStamp,startTime);
               LogObjectProxy.setRequest(request);
           }
        } catch (Throwable e) {
            Logger.error(e);
        }
    }


    public void doAfter(ServletRequest httpRequest, ServletResponse httpResponse, Throwable t, String signature) {


        try {
            if(HttpRequestUtils.isHttpServlet(httpRequest, httpResponse)){
                long endTime = System.currentTimeMillis();
                long execTime = endTime - LogObjectProxy.getTempDate().getLongValue(RequestTimeStamp);;
                String response = httpResponse.toString();

                LogObjectProxy.setMethod(execTime, t, response,signature, TypeEnum.Normal.name());

                LogObjectProxy.doLog();
                LogObjectProxy.clean();
            }
        } catch (Exception e) {
            Logger.error(e);
        }
    }


}
