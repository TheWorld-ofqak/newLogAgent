package com.qak.log.utils;

import com.fasterxml.uuid.Generators;
import com.qak.log.constants.MethodSignConstants;

import org.slf4j.MDC;

import java.util.Objects;



public class MdcUtils {

    public static void setLogId(String val) {
        val = Objects.isNull(val) ? Generators.timeBasedGenerator().generate().toString() : val;
        MDC.put(MethodSignConstants.TraceId, val);
//        MDC.put(LogConstants.mdc_appName, LogConfig.appName);
//        MDC.put(LogConstants.mdc_appEvn, LogConfig.appEvn);
    }

    public static String getLogId() {
        String logId = MDC.get(MethodSignConstants.TraceId);
        if (Objects.isNull(logId) ) {
            logId = Generators.timeBasedGenerator().generate().toString();
            MDC.put(MethodSignConstants.TraceId, logId);
            return logId;
        }
        return logId;
    }
}
