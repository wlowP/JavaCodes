package wlow02_java_advance._2_Exception;

import java.util.Scanner;

// 抛出自定义异常
public class _2_1_CustomException {
    public static void main(String[] args) {
        // 输入114514时抛出自定义异常
        Scanner sc = new Scanner(System.in);
        int a;
        try {
            a = sc.nextInt();
            if (a == 114514) throw new IDontLikeThisNumberException("不喜欢这个数字!");
        }catch (IDontLikeThisNumberException e){
            e.printStackTrace();
        }finally {
            System.out.println("lololol");
        }
    }
}