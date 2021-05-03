package io.promagent.internal.load;


import java.util.*;

// 暂时不支持自定义  支持默认的请求

public class HooksUtils {

//    private static List<String> controllerHook = Arrays.asList(
//            "org.springframework.web.bind.annotation.RequestMapping:CUSTOM",
//            "org.springframework.web.bind.annotation.PostMapping:CUSTOM",
//            "org.springframework.web.bind.annotation.GetMapping:CUSTOM",
//            "org.springframework.web.bind.annotation.DeleteMapping:CUSTOM",
//            "org.springframework.web.bind.annotation.PutMapping:CUSTOM");
    private static List<String> controllerHook = Arrays.asList(
            "org.springframework.web.bind.annotation.RequestMapping",
            "org.springframework.web.bind.annotation.PostMapping",
            "org.springframework.web.bind.annotation.GetMapping",
            "org.springframework.web.bind.annotation.DeleteMapping",
            "org.springframework.web.bind.annotation.PutMapping");

//    private static List<String> scheduledHook = Arrays.asList(
//            "org.springframework.scheduling.annotation.Scheduled:CRON");

    public static void addControllerHook(String packageName, AgentConfig.Hooks hooks) {
        addCommonAnnMethod(packageName, hooks, controllerHook);
    }


    private static void addCommonAnnMethod(String packageName, AgentConfig.Hooks hooks, List<String> defaultHookList) {
        packageName = "^" + packageName + ".*";
//        if (Collections.emptyMap(hooks.getAnnMethodHook().get(packageName))) {
//            hooks.getAnnMethodHook().put(packageName, new ArrayList<String>());
//        }
        hooks.getAnnMethodHook().put(packageName,defaultHookList);
    }

}
