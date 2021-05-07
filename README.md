
一个基于javaagent  + bytebuddy 字节码技术的无侵入AOP日志工具


里程牌1（目前的版本）：  引入该日志工具要使用在javaweb 项目启动时指定 jvm 启动语句的方式   -javaagent: xxx/xxx/LogAgent.jar 

优点：
当前使用简单，无代码侵入
支持traceid

缺点：
功能上： 目前不支持通过配置文件配置信息来完成 个性化的aop日志的配置。
工作效率： 之前在前前公司工作效率为 springaop 的  1.5倍。


