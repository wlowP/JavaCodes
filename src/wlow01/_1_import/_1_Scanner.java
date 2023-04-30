package wlow01._1_import;
//导包.
import java.util.Scanner;

public class _1_Scanner {
    public static void main(String[] args) {
        //创建对象.
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数:");
        //开始工作.
        int a = sc.nextInt();
        System.out.print ("请输入第二个数:");
        int b = sc.nextInt();
        System.out.print("求和:" + (a + b));
    }
}
