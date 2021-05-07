package com.qak.log;


import com.qak.log.constants.LogTypeEnum;
import com.qak.log.core.LogObjectProxy;
import com.qak.log.utils.MethodUtils;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description 请描述类的业务用途
 * @Author ankangqi
 * @Date 2020/12/25 6:29 下午
 **/
public class Logger {

    // 会被每个自定义的hook 去执行 第一次字节码增强 ，方法调用执行
    public static void info(Long execTime, Object ret, Method method, Object[] args,Throwable throwable) {

        try {

            String signature = MethodUtils.getSignature(method);
            LogObjectProxy.setMethod(execTime, throwable, null,signature , args,ret);
            LogObjectProxy.setLogType(LogTypeEnum.CUSTOM.getDesc());
            LogObjectProxy.setRequest(null);
            LogObjectProxy.doLog();
            LogObjectProxy.clean();

        }catch (Throwable e){
            error(e);
        }


    }


    public static void error(Throwable frameError) {

            LogObjectProxy.error(frameError);

    }

}

  