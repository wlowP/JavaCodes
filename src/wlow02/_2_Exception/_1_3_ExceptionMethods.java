package wlow02._2_Exception;

public class _1_3_ExceptionMethods {
    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println(str.toUpperCase());
        }catch (NullPointerException e){
            System.out.println("空指针异常!");
            System.out.println(
                    e + "\n" +
// java.lang.NullPointerException: Cannot invoke "String.toUpperCase()" because "str" is null
                    e.getMessage()
// Cannot invoke "String.toUpperCase()" because "str" is null
            );
            // 红字打印异常信息以及异常所在位置, 📌📌但是try-catch体系后面的语句也能正常执行
            e.printStackTrace();
        }
        System.out.println("这一段还是能执行");
    }
}
