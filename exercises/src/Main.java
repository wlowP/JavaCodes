import java.io.File;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("测试JAR包运行: " + LocalDateTime.now());
        System.out.println(new File("").getAbsolutePath());
        System.out.println(new File("/").getAbsolutePath());
    }
}