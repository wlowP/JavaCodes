package wlow01_java_basic._9_CollectionBasic.ArrayList._2_1_FindUser;

import java.util.ArrayList;
import java.util.Scanner;

public class FindTheUser {
            //在存有对象的集合中检索对象属性并判断是否有符合要求的对象.
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        User u1 = new User("rui001" , "reisen" , "123456");
        User u2 = new User("hm002" , "reimu" , "123456");
        User u3 = new User("km003" , "marisa" , "123456");
        list.add(u1);list.add(u2);list.add(u3);

        System.out.println(check(list));
    }


    //检查集合中是否有符合要求的元素的方法.
    public static boolean check(ArrayList<User> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查找的id>");
        String target = sc.next();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(target)){
                return true;
            }
        }
        return false;
    }
}
