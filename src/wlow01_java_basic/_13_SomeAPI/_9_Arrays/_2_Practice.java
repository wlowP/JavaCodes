package wlow01_java_basic._13_SomeAPI._9_Arrays;

import java.util.Arrays;

public class _2_Practice {
    public static void main(String[] args) {
        String[] strings = {"abc4322413", "ac22de", "aw4du5gwk", "39487211", "-=-=-=-=-==--=--=", "[][]"};

/*        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });*/

        //*********注意到Comparator是一个函数式接口.
        //用Lambda表达式:
        Arrays.sort(strings, (o1, o2) -> o1.length() - o2.length());


        System.out.println(Arrays.toString(strings));
    }
}
