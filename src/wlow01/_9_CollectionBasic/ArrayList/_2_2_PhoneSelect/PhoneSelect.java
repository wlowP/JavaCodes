package wlow01._9_CollectionBasic.ArrayList._2_2_PhoneSelect;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneSelect {
            //在集合当中筛选符合要求的元素并通过再打包成集合的方式返回多个数据.
    public static void main(String[] args) {
        ArrayList<Phone> list = new ArrayList<>();
        Phone p1 = new Phone("华为" , 5999.00);
        Phone p2 = new Phone("荣耀" , 4599.99);
        Phone p3 = new Phone("ROG" , 7999.00);
        list.add(p1);
        list.add(p2);
        list.add(p3);

        Scanner sc = new Scanner(System.in);
        System.out.println("输入要筛选的价格>");
        double limit = sc.nextDouble();

        ArrayList<Phone> list1 = select(list , limit);
        for (int i = 0; i < list1.size(); i++) {
            list1.get(i).sout();
        }
        if (list1.size() == 0){
            System.out.println("没有啊!");
        }
    }


    //筛选符合条件的元素的方法.
    public static ArrayList<Phone> select(ArrayList<Phone> list , double limit){
        ArrayList<Phone> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() <= limit){
                list1.add(list.get(i));
            }
        }
        return list1;
    }


}
