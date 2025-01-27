package wlow02_java_advance._7_JVM._3_JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class _3_BeforeAfter {
    @BeforeEach
    public void before(){
        System.out.println("在测试方法之前初始化数据, 拷贝一份...");
    }
    @Test
    public void test(){
        System.out.println(new File("").getAbsolutePath());
    }
    @AfterEach
    public void after(){
        System.out.println("测试完了要还原被测试的数据...");
    }
}
