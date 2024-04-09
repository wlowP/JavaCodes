package wlow01_java_basic._15_CollectionAndMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

        //集合的不同遍历方法: 迭代器, 增强for, forEach
public class _1_1_Coll_Traverse {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("123");
        coll.add("abc");
        coll.add("xyz");
        coll.add("mnq");

        System.out.println("=======迭代器遍历=======");
        //迭代器遍历.
        Iterator<String> it = coll.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("=======增强for=======");

        //增强for遍历. 底层用的也是迭代器.
        for (String s : coll){
            System.out.println(s);
        }
        System.out.println("=======forEach=======");

        //forEach遍历, lambda遍历.
        //方法要传递Consumer接口的实现类对象, 并且该接口是函数式接口.
        //匿名内部类:
        coll.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("==============");
        //lambda:
        coll.forEach(s -> System.out.println(s));
    }
}
