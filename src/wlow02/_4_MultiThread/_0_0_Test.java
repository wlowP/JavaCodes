package wlow02._4_MultiThread;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class _0_0_Test {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress ipAddr = InetAddress.getByName("REISEN");
        System.out.println(ipAddr);
    }
}

