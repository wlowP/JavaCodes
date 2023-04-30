package wlow01._15_CollectionAndMap._10_practice;

import java.util.ArrayList;
import java.util.Random;

// 26字母表随机抽一个字母
public class _1_CallNames1 {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<String> list = Util.alphabet();
        System.out.println(list);
        for (int i = 0; i < 50; i++) {
            System.out.println(list.get(r.nextInt(list.size())));
        }
    }
}
