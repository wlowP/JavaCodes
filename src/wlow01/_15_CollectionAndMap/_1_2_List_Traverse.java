package wlow01._15_CollectionAndMap;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class _1_2_List_Traverse {
    //List集合的特有遍历方式: 列表迭代器
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("abc");
        list.add("xyz");
        list.add("mnq");
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        //列表迭代器
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("=====反着迭代=====");
        //📌📌📌可以反着迭代.
        while (it.hasPrevious()){
            System.out.println(it.previous());
        }
        //迭代同时替换元素.
        while (it.hasNext()){
            if (it.next().equals("aaa")){
                it.set("xxxxx");
            }
        }
        System.out.println(list); //[123, abc, xyz, mnq, xxxxx, bbb, ccc, ddd]
        //迭代同时添加元素
        while (it.hasPrevious()){
            if (it.previous().equals("xxxxx")){
                it.add("lololol");
            }
        }
        System.out.println(list); //[123, abc, xyz, mnq, lololol, xxxxx, bbb, ccc, ddd]
        while (it.hasNext()){
            if (it.next().equals("xxxxx")){
                it.add("wwwwwww");
            }
        }
        System.out.println(list); //[123, abc, xyz, mnq, lololol, xxxxx, wwwwwww, bbb, ccc, ddd]
    }
}
