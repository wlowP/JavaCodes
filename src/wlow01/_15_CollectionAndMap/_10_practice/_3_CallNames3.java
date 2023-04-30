package wlow01._15_CollectionAndMap._10_practice;

import java.util.ArrayList;
import java.util.Random;

// 抽到以后就不会再抽到了, 如果抽完了就在重开一轮
public class _3_CallNames3 {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<String> list = Util.alphabet(),
                          called = new ArrayList<>();
        int index;
        String item;
        for (int i = 0; i < 45; i++) {
            if (list.size() == 0) {
                System.out.println("再开一轮");
                list.addAll(called);
                called.clear();
            }
            index = r.nextInt(list.size());
            // 注意remove会返回删除的元素, 直接sout即可
            item = list.remove(index);
            System.out.println(item);
            called.add(item);
        }
        System.out.println(list);
    }
}
