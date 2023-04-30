package wlow01._15_CollectionAndMap;

import java.util.ArrayList;

public class _1_3_Generics {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        util.add4(list, "123", "456", "789", "890");
        System.out.println(list);

        ArrayListFake<Integer> list1 = new ArrayListFake<>();

        list1.add(8998);
        list1.add(1234);

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }
}

//泛型类.
class ArrayListFake<E>{
    Object[] objs;
    private int size;

    public ArrayListFake(){
        objs = new Object[10];
    }

    public ArrayListFake(int initSize){
        objs = new Object[initSize];
    }

    public int size(){
        return size;
    }

    public E get(int index){
        return (E)objs[index];
    }

    public boolean add(E e){
        objs[size] = e;
        size++;
        return true;
    }
}

class util{
    private util(){}

    //泛型方法.
    public static <E> void add4(ArrayList<E> list, E e1, E e2, E e3, E e4){
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
    }
}
