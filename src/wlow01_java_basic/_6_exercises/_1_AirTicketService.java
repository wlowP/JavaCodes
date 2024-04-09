package wlow01_java_basic._6_exercises;

import java.util.Scanner;

public class _1_AirTicketService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("机票原价是多少呀亲?>");
        double cost = sc.nextDouble();
        System.out.println("几月份的机票呀?>");
        int month = sc.nextInt();
        System.out.println("头等舱请输入1, 经济舱请输入2>");
        int type = sc.nextInt();

        //**只用if嵌套的话代码有重复.所以创建一个方法.

        if(5 <= month && month <= 10){

            System.out.println("亲您的最终票价是:" + calc(cost , type , 0.9 , 0.85));

        }else if(1 <= month && month <= 4 || 11 <= month && month <= 12){

            System.out.println("亲您的最终票价是:" + calc(cost , type , 0.7 , 0.65));


        }else{
            System.out.println("亲您是不是搞错了什么?");
        }


            //不用方法的版本:
/*        if(5 <= month && month <= 10){

            if(type == 1){
                System.out.println("亲您的最终票价是:" + (cost * 0.9) + "哟~");
            }else if(type == 2){
                System.out.println("亲您的最终票价是" + (cost * 0.85) + "哟~");
            }else{
                System.out.println("亲您是不是搞错了什么?");
            }

        }else if(1 <= month && month <= 4 || 11 <= month && month <= 12){

            if(type == 1){
                System.out.println("亲您的最终票价是:" + (cost * 0.7) + "哟~");
            }else if(type == 2){
                System.out.println("亲您的最终票价是" + (cost * 0.65) + "哟~");
            }else{
                System.out.println("亲您是不是搞错了什么?");
            }

        }else{
            System.out.println("亲您是不是搞错了什么?");
        }*/
    }

    public static double calc(double cost , int type , double v1 , double v2){
        switch(type){
            case 1:
                cost *= v1;
                break;
            case 2:
                cost *= v2;
                break;
            default:
                System.out.println("没有这个舱位哟~");
                break;
        }
        return cost;

    }
}
