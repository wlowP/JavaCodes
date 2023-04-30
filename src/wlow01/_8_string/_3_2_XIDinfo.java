package wlow01._8_string;

import java.util.Scanner;

public class _3_2_XIDinfo {
            //从身份证号码里面提取出生年月, 性别的信息.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入18位身份证号码>");
        String id = sc.next(); //18位的

        //*****通过加减ASCII值的办法来实现char类型阿拉伯数字转int类型.
        char g = id.charAt(17);
        char gender;
/*
        int gend = g - 48;

        if (gend % 2 == 0){
            gender = '女';
        }else{
            gender = '男';
        }
*/
        //***然后发现ASCII表里控制字符0~9的ASCII值与其字符奇偶性一致,
        //***并且char类型数据计算时自动转换为int类型,
        //***所以仅是判断奇偶性的话, 直接让char类型的阿拉伯数字对2取余即可.
        if (g % 2 == 0){
            gender = '女';
        }else{
            gender = '男';
        }

        System.out.println("出生日期:" + id.substring(6,10) + "年" + id.substring(10 ,12) + "月" + id.substring(12 , 14) + "日");
        System.out.println("性别:" + gender);
    }
}
