package io.promagent.core;


import io.promagent.entity.LogObject;

/**
 * @Description
 * @Author ankangqi
 * @Date 2020/12/12 4:31 下午
 * <p>
 * mdc
 * https://blog.csdn.net/userwyh/article/details/52862216
 **/
public class LogContext {

    private static final ThreadLocal<LogObject> threadLocal = ThreadLocal.withInitial(LogObject::new);


    public static LogObject get() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }

}

  