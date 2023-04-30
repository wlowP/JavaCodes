package wlow01._8_string;

import java.util.Scanner;

public class _2_0_TraverseAndCount {
            //统计字符串中大写字母、小写字母、数字的个数.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入字符串>");
        String str = sc.nextLine();
        //遍历字符串.
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
        System.out.println("字符串长度:" + str.length());
        //统计字符串中的大写小写字母和数字个数
        int[] arr = new int[3];
        countCase(str , arr);
        System.out.println("大写字母有:" + arr[0] + "个, " + "小写字母有:" + arr[1] + "个, " + "数字有:" + arr[2] + "个.");
    }

    //统计字符串中的大写、小写字母和数字的个数.
    public static void countCase(String str , int[] arr){
        for (int i = 0; i < str.length(); i++) {

            //*****charAt出来的数据和'X'的数据都是char类型, 在参与运算(比较大小)的时候自动转换为int类型.
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                //大写.
                arr[0]++;
            }else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                //小写.
                arr[1]++;
            }else if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                //数字.
                arr[2]++;
            }
        }
    }

}
