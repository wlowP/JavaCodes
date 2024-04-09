package wlow02_java_advance._7_JVM._2_ClassLoader;

// 类加载器对象
public class _1_0_GetClassLoader {
    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的"父级" - 平台类加载器
        ClassLoader platformClassLoader = systemClassLoader.getParent();
        System.out.println(platformClassLoader);

        // 再获取平台类加载器的"父级" - 启动类加载器, 但一般获取到null, 因为是C++写的, java语言没有实现
        ClassLoader bootstrapClassLoader = platformClassLoader.getParent();
        System.out.println(bootstrapClassLoader);
    }
}
