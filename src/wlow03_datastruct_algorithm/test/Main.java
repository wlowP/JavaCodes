package wlow03_datastruct_algorithm.test;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);

        System.out.println(list);

        list.remove(Integer.valueOf(1));

        System.out.println(list);
    }
}
