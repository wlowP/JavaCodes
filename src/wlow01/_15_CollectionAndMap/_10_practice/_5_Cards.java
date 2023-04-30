package wlow01._15_CollectionAndMap._10_practice;


import java.util.*;

// 模拟卡牌
public class _5_Cards {

    static HashMap<Integer, String> allCards = Util.cardMap();

    public static void main(String[] args) {
        // 生成数字值和牌对应的Map

        ArrayList<Integer> cardNum = new ArrayList<>();
        for (int i = 1; i <= 54; i++) {
            cardNum.add(i);
        }

        // 存储底牌, 3名玩家的牌的Set集合
        TreeSet<Integer> base = new TreeSet<>(),
                         p1 = new TreeSet<>(),
                         p2 = new TreeSet<>(),
                         p3 = new TreeSet<>();
        Collections.shuffle(cardNum);

        // 发牌时只用发代表牌值的序号
        for (int i = 0; i < cardNum.size(); i++) {
            int num = cardNum.get(i);
            if (i < 3){
                base.add(num);
            }else{
                if (i % 3 == 0) p1.add(num);
                else if (i % 3 == 1)  p2.add(num);
                else p3.add(num);
            }
        }

        // 看牌时再到Map里面找
        look("base", base);
        look("p1", p1);
        look("p2", p2);
        look("p3", p3);
    }

    public static void look(String playerName, TreeSet<Integer> set){
        System.out.print(playerName + ": ");
        for (int i : set) {
            System.out.print(allCards.get(i) + " ");
        }
        System.out.println();
    }
}
