package io.promagent.internal.custom;

/**
 * @description: 用来对通用的方法来进行字节码增强
 * @author: qiankang
 * @time: 2021/5/3 9:53
 */
import io.promagent.agent.ClassLoaderCache;
import net.bytebuddy.implementation.bytecode.assign.Assigner;

import java.lang.reflect.Method;

import static net.bytebuddy.asm.Advice.*;


public class CustomByteBuddyAdvice {


    private final static String callMethodPath = "com.qak.log.Logger";

    @OnMethodEnter
    @SuppressWarnings("unckecked")
    public static Long before(){return System.currentTimeMillis();}

    @OnMethodExit(onThrowable = Throwable.class)
    public static void after (@Enter Long startTime,
                              @Origin Method method,
                              @AllArguments Object[] args,
                              @Return(typing = Assigner.Typing.DYNAMIC) Object returned ,
                              @Thrown Throwable throwable){

           Class<?> loggerClass = null;
           try {
               loggerClass = ClassLoaderCache.getInstance().currentClassLoader().loadClass(callMethodPath);
               Method logMethod = loggerClass.getMethod("info",Long.class,Object.class,Method.class,Object[].class,Throwable.class);
               long exec = System.currentTimeMillis() - startTime ;

               logMethod.invoke(null,exec,returned,method,args,throwable);
           }catch (Throwable frameError){

               try {
                   if (loggerClass == null) {
                       loggerClass = ClassLoaderCache.getInstance().currentClassLoader().loadClass(callMethodPath);
                   }
                   if (loggerClass != null) {
                       Method frameErrorMethod = loggerClass.getMethod("error", Throwable.class);
                       frameErrorMethod.invoke(null, frameError);
                   }
               } catch (Throwable ignore) {
                   ignore.printStackTrace();
               }
           }

    }





}
