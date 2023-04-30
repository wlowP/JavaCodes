package wlow01._15_CollectionAndMap;

import java.util.ArrayList;
import java.util.Collection;

public class _1_0_Collection {
    public static void main(String[] args) {

        Collection<String> coll = new ArrayList<>();
        coll.add("1");
        coll.add("11243");
        coll.add("112");
        coll.add("2");
        coll.add("fuoidghfdjkh");
        System.out.println(coll);
        coll.remove("1");

        System.out.println(coll);
        System.out.println(coll.contains("2"));

    }
}
