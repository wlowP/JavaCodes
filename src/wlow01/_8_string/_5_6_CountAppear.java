package wlow01._8_string;

import java.util.Scanner;

public class _5_6_CountAppear {
            //统计一句话中某一个关键词(字符串)一共出现了几次.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一句话>");
        String say = sc.next();
        //输入要检测的关键词:
        System.out.println("请输入要检测的关键词(英文的话会区分大小写)>");
        String target = sc.next();

        System.out.println(target + "一共出现了" + count(say , target) + "次.");

    }



    //在一个字符串中检索并计数指定关键词出现的次数.
    public static int count(String str , String target){
        int count = 0;
        int temp = str.length();
        for (int i = 0; i < temp; i++) {
        //千万不要在循环外面新建sb对象.
        StringBuilder sb = new StringBuilder();
        int v = str.indexOf(target);
            if (v != -1){
                count++;
                str = sb.append(str, 0, v).append(str.substring(v+4)).toString();
                //System.out.println(count);
                //System.out.println(str);
            }else{
                break;
            }
        }
        return count;
    }
}
