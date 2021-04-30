package io.promagent;


import io.promagent.core.LogObjectProxy;
import io.promagent.enums.TypeEnum;
import io.promagent.utils.MethodUtils;

import java.lang.reflect.Method;

/**
 * @Description 请描述类的业务用途
 * @Author ankangqi
 * @Date 2020/12/25 6:29 下午
 **/
public class Logger {

    // 会被每个自定义的hook 去执行 第一次字节码增强 ，方法调用执行
    public static void info(Long execTime, Throwable throwable, Object ret, Method method, Object args) {

        try {

            String signature = MethodUtils.getSignature(method);
            LogObjectProxy.setMethod(execTime, throwable, ret,signature , TypeEnum.Normal.name());

            LogObjectProxy.doLog();

        }catch (Throwable e){
            error(e);
        }


    }


    public static void error(Throwable frameError) {
        try {
            frameError.printStackTrace();
            LogObjectProxy.error(frameError);
        } catch (Throwable ignore) {
            ignore.printStackTrace();
        }
    }

}

  