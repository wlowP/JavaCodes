package wlow01_java_basic._8_string;


import java.util.Random;
import java.util.Scanner;

public class _5_3_VerificationCode_2 {
            //自定义长度的随机验证码.数字可以出现在任意一位.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要的验证码长度>");
        int len = sc.nextInt();
        while(len < 3){
            System.out.println("输入的长度不合理!请重新输入!");
            len = sc.nextInt();
        }
        System.out.println("创建验证码:");
        System.out.println(createCode(len));
    }



    //创建验证码的方法.
    public static String createCode(int len){
        Random r = new Random();
        char[] code = new char[len];
        //***先创建包含所有大小写字母的字符数组.
        char[] letter = new char[52];
        for (int i = 0; i < letter.length; i++) {
            if (i <= 25){
                letter[i] = (char)(i + 65);
            }else{
                letter[i] = (char)(i + 71);
            }
        }
        for (int i = 0; i < code.length; i++) {
            int ranIndex = r.nextInt(letter.length);
            code[i] = letter[ranIndex];
        }
        //将其中一位替换为数字.
        //也可以先把数字放在第一个, 再打乱数数组.
        code[r.nextInt(code.length)] =(char) (r.nextInt('0' , '9'));
        return new String(code);
    }
}
