package wlow01_java_basic._9_CollectionBasic.ArrayList._1_0_Basic;

import java.util.ArrayList;
import java.util.Scanner;

public class _1_0_Basic {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("输入要添加的内容>");
            String str = sc.next();
            list.add(str);
        }

        //System.out.println(list);
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size()-1){
                System.out.print(list.get(i) + "]");
            }else {
                System.out.print(list.get(i) + ", ");
            }
        }
    }
}
