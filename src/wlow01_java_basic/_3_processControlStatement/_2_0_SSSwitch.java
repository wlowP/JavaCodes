package wlow01_java_basic._3_processControlStatement;

import java.util.Scanner;

public class _2_0_SSSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("亲您要点啥呀?");
        String order = sc.next();

/*        switch(order){
            case "原味板烧鸡腿堡":
                System.out.println("原味板烧鸡腿堡, 单点17.99元, 套餐26.99元.");
                break;
            case "巨无霸":
                System.out.println("巨无霸, 单点25.99元, 套餐34.89元.");
                break;
            case "麦香鱼":
                System.out.println("麦香鱼, 单点12.79元, 套餐19.33元.");
                break;
            case "麦乐鸡":
                System.out.println("麦乐鸡单点10.00元.");
                break;
            default:
                System.out.println("亲您是不是搞错了什么呐~?");
                break;
        }*/

        //JDK12及其以后才有的switch简化版:

        switch (order){
            case "原味板烧鸡腿堡" -> System.out.println("原味板烧鸡腿堡, 单点17.99元, 套餐26.99元.");
            case "巨无霸" -> System.out.println("巨无霸, 单点25.99元, 套餐34.89元.");
            case "麦香鱼" -> System.out.println("麦香鱼, 单点12.79元, 套餐19.33元.");
            case "麦乐鸡" -> System.out.println("麦乐鸡单点10.00元.");
            default -> System.out.println("亲您是不是搞错了什么呐~?");
            //只执行一行代码时, 大括号可以省略.



        }

    }
}
