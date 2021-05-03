package io.promagent.internal.load;

import com.alibaba.fastjson.JSONObject;

/**
 * @description: 写下类的功能描述
 * @author: qiankang
 * @time: 2021/5/3 11:13
 */


public class AgentBootstrap {



    public  void initSystemProperty()  {
        AgentConfig agentConfig = new AgentConfig();
        AgentConfig.Hooks hooks = agentConfig.getHooks() ;

        HooksUtils.addControllerHook("defaultMethod", hooks);
        System.setProperty("agent.hooks.annMethodHook", JSONObject.toJSONString(hooks.getAnnMethodHook()));

    }
}