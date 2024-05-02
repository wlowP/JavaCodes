package wlow02_java_advance._7_JVM._3_JUnit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _2_Assert {
    @Test
    public void test(){
        TestClass tc = new TestClass();
        int res = tc.sum(4, 5);
        // System.out.println(res);
        Assertions.assertEquals(9, res, "出现错误! 结果不符合预期!");
    }
}

class TestClass {
    int sum(int a, int b){
        // 逻辑错误: 加法写成了乘法
        return a * b;
    }
}

