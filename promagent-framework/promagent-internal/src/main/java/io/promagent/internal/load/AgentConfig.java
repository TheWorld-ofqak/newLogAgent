package io.promagent.internal.load;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.*;


/**
 *
 * @description:
 * @author: qiankang
 * @time: 2021/5/3 11:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentConfig {

    private Hooks hooks = new Hooks();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Hooks {
        private Map<String, List<String>> annMethodHook = new HashMap<>();
        //private Map<String, List<String>> annClassHook = new HashMap<>();

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AgentConfigPrefix {
        private AgentConfig promagent;
    }
}


