package wlow02._2_Exception;

public class _1_1_CauseException {
    public static void main(String[] args) {

        String[] arr = new String[3];
        System.out.println("1111111");
        // 空指针异常 NullPointerException
        //System.out.println(arr[0].toUpperCase());
        // 索引越界异常 ArrayIndexOutOfBoundsException
        // 📌📌如果异常信息有很多行, 从下往上看.
        System.out.println(new Student("lolololol"));
        System.out.println("前面有异常的话不会执行");
    }
}
