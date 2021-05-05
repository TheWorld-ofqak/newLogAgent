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



    public  void initSystemProperty()  {

        /*
         AgentConfig agentConfig = new AgentConfig();
         AgentConfig.Hooks hooks = agentConfig.getHooks() ;
         HooksUtils.addControllerHook("defaultMethod", hooks);
         */

        Map<String, List<String>> annMethodMap = new HashMap<>();
        annMethodMap.put("defaultMethod",controllerHook);
        String jsonString = JSONObject.toJSONString(annMethodMap);

        System.err.println(jsonString);
        System.setProperty("agent.hooks.annMethodHook", jsonString);

    }
}