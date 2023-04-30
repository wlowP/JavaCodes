package wlow01._7_object_oriented._4_XShoppingCart;

import java.util.Scanner;

public class _Model_1_CarTest {
    public static void main(String[] args) {
        //1.创建一个数组用来存3个汽车对象
        _Model_1_Car[] arr = new _Model_1_Car[3];

        //2.创建汽车对象，数据来自于键盘录入
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            //创建汽车的对象  *****这里的c只是个搬运工, 负责把新建对象的地址值转到数组里, c只在每次循环内存在
            _Model_1_Car c = new _Model_1_Car();
            //录入品牌
            System.out.println("请输入汽车的品牌");
            String brand = sc.next();
            c.setBrand(brand);
            //录入价格
            System.out.println("请输入汽车的价格");
            int price = sc.nextInt();
            c.setPrice(price);
            //录入颜色
            System.out.println("请输入汽车的颜色");
            String color = sc.next();
            c.setColor(color);
            System.out.println(c);

            //把汽车对象添加到数组当中
            arr[i] = c;
        }

        //3.遍历数组
        for (int i = 0; i < arr.length; i++) {
            _Model_1_Car car = arr[i];
            System.out.println(car.getBrand() + ", " + car.getPrice() + ", " + car.getColor());
        }
    }
}
