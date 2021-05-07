package io.promagent.internal.load;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 写下类的功能描述
 * @author: qiankang
 * @time: 2021/5/3 11:13
 */


public class AgentBootstrap {


    private static List<String> controllerHook = Arrays.asList(
            "org.springframework.web.bind.annotation.RequestMapping",
            "org.springframework.web.bind.annotation.PostMapping",
            "org.springframework.web.bind.annotation.GetMapping",
            "org.springframework.web.bind.annotation.DeleteMapping",
            "org.springframework.web.bind.annotation.PutMapping");

    private static String  hookPackage =  "com.*.*.controller";



    public  void initSystemProperty()  {

        /*
         AgentConfig agentConfig = new AgentConfig();
         AgentConfig.Hooks hooks = agentConfig.getHooks() ;
         HooksUtils.addControllerHook("defaultMethod", hooks);
         */

        String packageName = "^" + hookPackage + ".*";
        Map<String, List<String>> annMethodMap = new HashMap<>();

        annMethodMap.put(packageName,controllerHook);
        String jsonString = JSONObject.toJSONString(annMethodMap);

        System.err.println("注解增强的包："+packageName+jsonString);
        System.setProperty("agent.hooks.annMethodHook", jsonString);

    }
}