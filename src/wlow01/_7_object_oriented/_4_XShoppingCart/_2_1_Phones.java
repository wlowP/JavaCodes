package wlow01._7_object_oriented._4_XShoppingCart;

import java.util.Scanner;

public class _2_1_Phones {

    public static void main(String[] args) {

        _2_0_Phone[] arr = new _2_0_Phone[4];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            //搬运工p.
            _2_0_Phone p = new _2_0_Phone();
            System.out.println("请输入手机品牌>");
            p.setBrand(sc.next());
            System.out.println("请输入手机价格>");
            p.setPrice(sc.nextDouble());
            System.out.println("请输入手机颜色>");
            p.setColor(sc.next());

            arr[i] = p;
        }


        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (int)(arr[i].getPrice());
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getBrand() + ", " + arr[i].getPrice() + ", " + arr[i].getColor());
        }

        int avg = sum / arr.length;
        System.out.println("平均价格是:" + avg);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getPrice() < avg){
                System.out.println(arr[i].getBrand() + ", " + arr[i].getPrice());
                count++;
            }
        }
        System.out.println("共有" + count + "种型号低于平均价格.");

    }
}
