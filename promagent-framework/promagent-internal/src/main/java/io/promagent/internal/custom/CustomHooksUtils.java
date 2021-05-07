package io.promagent.internal.custom;

import com.alibaba.fastjson.JSON;
import io.promagent.agent.ClassLoaderCache;
import io.promagent.internal.custom.CustomByteBuddyAdvice;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.matcher.ElementMatchers;

import java.util.List;
import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.nameMatches;

/**
 * @description: 通用hook的工具类 构建 agentbulider
 * @author: qiankang
 * @time: 2021/5/3 11:25
 */


public class CustomHooksUtils {


    // 目前只有对注解方法进行使用
    public static AgentBuilder applyHooks(AgentBuilder agentBuilder, ClassLoaderCache classLoaderCache){

        agentBuilder = applyAnnMethodHook(agentBuilder,classLoaderCache);// 构建要进行横切的 自定义类的 agentBuilder
        return agentBuilder;
    }

    // 已注解的方式来标记增强的方法
    private static AgentBuilder applyAnnMethodHook(AgentBuilder agentBuilder, ClassLoaderCache classLoaderCache) {

        String annMethodHook = System.getProperty("agent.hooks.annMethodHook");
        System.err.println("注解标注的hooks："+annMethodHook);
        if (annMethodHook == null) {
            return agentBuilder;
        }
        Map<String, List<String>> annMethodHookMap = JSON.parseObject(annMethodHook, Map.class);
        for (Map.Entry<String, List<String>> entry : annMethodHookMap.entrySet()) {
            for (String value : entry.getValue()) {
                agentBuilder = agentBuilder
                        .type(nameMatches(entry.getKey()))
                        .transform(getForAdvice(classLoaderCache).advice(ElementMatchers.isAnnotatedWith(ElementMatchers.named(value)), CustomByteBuddyAdvice.class.getName()));
            }
        }
        System.err.println("--------注解标注的切点字节码完成标记--------");
        return agentBuilder;

    }

    private static AgentBuilder.Transformer.ForAdvice getForAdvice(ClassLoaderCache classLoaderCache) {
        return new AgentBuilder.Transformer.ForAdvice().include(classLoaderCache.currentClassLoader());
    }


}
