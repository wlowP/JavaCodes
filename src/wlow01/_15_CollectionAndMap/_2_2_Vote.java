package wlow01._15_CollectionAndMap;

import java.util.HashMap;
import java.util.Random;

// 对于投票项目较多或者不知道有多少种投票选择时, Map统计会比设立计数器统计好一点.
public class _2_2_Vote {
    public static void main(String[] args) {
        HashMap<Character, Integer> vote = new HashMap<>();
        Random r = new Random();
        char option;
        for (int i = 0; i < 100; i++) {
            option = (char)r.nextInt('A', 'H');
            if (vote.containsKey(option)){
                vote.put(option, vote.get(option) + 1);
            }else{
                vote.put(option, 1);
            }
        }
        vote.forEach((k, v)-> System.out.println(k + "=" + v));
    }

}
