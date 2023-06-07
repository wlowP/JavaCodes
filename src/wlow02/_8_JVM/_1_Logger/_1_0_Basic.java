package wlow02._8_JVM._1_Logger;

// Java也有自带的logger: java.util.logging.Logger 别导错包了

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 日志的基本使用
public class _1_0_Basic {
    // 1. 先获取logger对象. 要传递字节码文件表示是谁记录的日志
    public static final Logger logger = LoggerFactory.getLogger(_1_0_Basic.class);

    public static void main(String[] args) {
        // 2. 想记录日志时就调用logger对象的方法
        logger.info("这是一条日志");
        logger.warn("警告");
        logger.error("错误");
        // 控制台输出:
        // 2023-06-03 23:11:17.100 [INFO ] wlow02._7_Proxy._2_Logger._1_0_Basic [main] : 这是一条日志
        // 2023-06-03 23:11:17.101 [WARN ] wlow02._7_Proxy._2_Logger._1_0_Basic [main] : 警告
        // 2023-06-03 23:11:17.101 [ERROR] wlow02._7_Proxy._2_Logger._1_0_Basic [main] : 错误
        // 同时也会输出到文件中
    }
}
