package wlow01._0_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Test<Integer, Integer> t = new Test<>();
        t.addAll(1, 2, 3, 4, 5);
        t.handle((num)-> num + 1);
    }
}

class Test<T, R>{
    ArrayList<T> list = new ArrayList<>();
    public Test(){}
    void addAll(T... t){
        Collections.addAll(list, t);
    }
    void handle(Function<T, R> fun){
        list.forEach(num-> System.out.println(fun.apply(num)));
    }
}