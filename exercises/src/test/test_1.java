package test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class test_1 {
    // 📌📌单元测试中的相对路径是从当前模块根目录开始的, 不同于一般情况下的项目根目录
    @Test
    public void test() {
        System.out.println(new File("").getAbsolutePath()); // F:\codes\practice\JavaCodes\exercises
    }
}

