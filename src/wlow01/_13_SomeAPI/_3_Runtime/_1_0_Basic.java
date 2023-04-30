package wlow01._13_SomeAPI._3_Runtime;

public class _1_0_Basic {
    public static void main(String[] args) {
        //获取CPU可用线程数.
        System.out.println(Runtime.getRuntime().availableProcessors());
        //获取虚拟机能从系统中获取的总内存大小.单位是byte, 除以1024^2得MB
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
    }
}
