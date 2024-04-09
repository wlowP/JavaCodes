package wlow01_java_basic._8_string;

import java.util.Scanner;

public class _3_0_$$Conversion {
            //将输入的七位数字金额转换为中文大写金额.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要转换的金额>");
        int money_dgt = sc.nextInt();
        //*****别忘了排除不合理数据.
        while (true) {
            if (money_dgt >= 0 && money_dgt <= 9999999 ) {
                break;
            }else{
                System.out.println("输入的数字超出范围!请重新输入!");
                money_dgt = sc.nextInt();
            }
        }


        String result = convert(money_dgt);
        System.out.println(result);
    }


    public static String convert (int dgt){

        //先进行数位提取.
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            int ge = dgt % 10;
            arr[i] = ge;
            dgt /= 10;
        }

        //再进行大写汉字赋值.
        char[] wei = new char[7];
        String capital = "零壹贰叁肆伍陆柒捌玖";
        for (int i = 0; i < 7; i++) {
            /*switch(arr[i]){
                default:
                    wei[i] = '零';
                    break;
                case 1 :
                    wei[i] = '壹';
                    break;
                case 2 :
                    wei[i] = '贰';
                    break;
                case 3 :
                    wei[i] = '叁';
                    break;
                case 4 :
                    wei[i] = '肆';
                    break;
                case 5 :
                    wei[i] = '伍';
                    break;
                case 6 :
                    wei[i] = '陆';
                    break;
                case 7 :
                    wei[i] = '柒';
                    break;
                case 8 :
                    wei[i] = '捌';
                    break;
                case 9 :
                    wei[i] = '玖';
                    break;
            }*/

            //*****让索引与大写数字一一对应, 这样更方便简洁!!!
            wei[i] = capital.charAt(arr[i]);
        }

        String money = wei[6] +  "佰" + wei[5] +  "拾" + wei[4] + "万"  + wei[3] + "仟"  + wei[2] + "佰"  + wei[1] + "拾"  + wei[0] + "元";
        return money;
    }

}
