package wlow01._15_CollectionAndMap._10_practice;

import java.util.ArrayList;
import java.util.HashMap;

public class Util {
    private Util(){}
    public static ArrayList<String> alphabet(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(String.valueOf((char)(i + 65)));
        }
        return list;
    }

    public static HashMap<Integer, String> cardMap(){
        String[] colors = {"♦", "♣", "♥", "♠"},
                numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        HashMap<Integer, String> cardMap = new HashMap<>();
        int serialNum = 1;

        for (String number : numbers) {
            for (String color : colors) {
                cardMap.put(serialNum, color + number);
                serialNum++;
            }
        }

        cardMap.put(serialNum, "小王");
        serialNum++;
        cardMap.put(serialNum, "大王");
        return cardMap;
    }
}
