package wlow01_java_basic._7_object_oriented._3_XTextFTG;


import java.util.Random;

public class _1_1_FTG_2 {
            //文字版格斗游戏.
    public static void main(String[] args) {
        _1_0_XCharacter Reimu = new _1_0_XCharacter("博丽灵梦" , 1000);
        _1_0_XCharacter Marisa = new _1_0_XCharacter("雾雨魔理沙" , 1000);
        System.out.println(Reimu.getName() + ", " + Reimu.getAppearance() + ", 血量为:" + Reimu.getHealth());
        System.out.println(Marisa.getName() + ", " + Marisa.getAppearance() + ", 血量为:" + Marisa.getHealth());

        //随机决定谁是先手.
        Random r = new Random();
        int s = r.nextInt(1,3);
        while(true){
            if (s == 1){
                Marisa.attack2(Reimu);
                if(Reimu.getHealth() == 0){
                    System.out.println();
                    System.out.println("雾雨魔理沙击败了博丽灵梦!!");
                    break;
                }
                Reimu.attack2(Marisa);
                if(Marisa.getHealth() == 0){
                    System.out.println();
                    System.out.println("博丽灵梦击败了雾雨魔理沙!!");
                    break;
                }
            }else {
                Reimu.attack2(Marisa);
                if(Marisa.getHealth() == 0){
                    System.out.println();
                    System.out.println("博丽灵梦击败了雾雨魔理沙!!");
                    break;
                }
                Marisa.attack2(Reimu);
                if(Reimu.getHealth() == 0){
                    System.out.println();
                    System.out.println("雾雨魔理沙击败了博丽灵梦!!");
                    break;
                }
            }
        }


    }
}
