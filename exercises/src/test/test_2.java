package test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class test_2 {
    public static void main(String[] args) throws IOException {
        System.out.println(new File("../").getAbsolutePath()); // F:\codes\practice\JavaCodes\..
        // getCanonicalPath()会将路径中的..和.转换成实际的路径, 但是注意会抛出编译时异常
        System.out.println(new File("../").getCanonicalPath()); // F:\codes\practice
    }
}
