package wlow02_java_advance._7_JVM._3_JUnit;

import org.junit.jupiter.api.Test;

// 单元测试
public class _1_UnitTest {
    static int num = 0;
    // 📌📌被测试的方法必须是public的, 空参的, 无返回值的, 非静态的.
    @Test
    public void method(){
        System.out.println(1/0);
        System.out.println(n());
    }

    @Test
    public void method2(){
        System.out.println("UnitTest.method2");
        System.out.println(n());
    }

    static int n(){
        // 如果num不是静态的, 上面两次调用时打印的都是0
        return num++;
    }
}

