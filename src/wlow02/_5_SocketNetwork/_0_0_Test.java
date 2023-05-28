package wlow02._5_SocketNetwork;

import java.util.UUID;

public class _0_0_Test {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid.toString().replace("-", ""));
        // 一次输出:
        // 57b4352b-c649-4d99-87db-028487f41b59
        // 57b4352bc6494d9987db028487f41b59
    }
}
