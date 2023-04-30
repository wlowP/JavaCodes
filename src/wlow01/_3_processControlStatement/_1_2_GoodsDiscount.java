package wlow01._3_processControlStatement;

import java.util.Scanner;

public class _1_2_GoodsDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("亲请输入商品原价:");
        double v = sc.nextDouble();

        System.out.println("亲您的会员级别是?");
        int lv = sc.nextInt();

        if(lv == 1){
            System.out.println("亲爱的一级会员,为您打九折哟~实付:" + v*0.9);
        }else if(lv == 2){
            System.out.println("亲爱的二级会员,为您打八折哟~实付:" + v*0.8);
        }else if(lv == 3){
            System.out.println("亲爱的三级会员,您享有七折优惠哟~实付:" + v*0.7);
        }else {
            System.out.println("亲您是不是搞错了呢?没有会员的话不打折哟");
        }

    }
}