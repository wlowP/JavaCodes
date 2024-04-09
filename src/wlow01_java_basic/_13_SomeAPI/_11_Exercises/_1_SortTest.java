package wlow01_java_basic._13_SomeAPI._11_Exercises;

import java.util.Arrays;

public class _1_SortTest {
    public static void main(String[] args) {
        GirlFriend[] girlFriends = {
            new GirlFriend("a铃仙·优昙华院·因幡", 19, 175.0),
            new GirlFriend("e比那名居天子", 188, 170.0),
            new GirlFriend("b博丽灵梦", 18, 170.0),
            new GirlFriend("c蕾米莉亚·斯卡雷特", 500, 160.0),
            new GirlFriend("d芙兰朵露·斯卡雷特", 495, 163.0)
        };

/*        Arrays.sort(girlFriends, (g1, g2) -> {
            double temp = g1.getAge() - g2.getAge();
            temp = temp == 0 ? g1.getHeight() - g2.getHeight() : temp;
            temp = temp == 0 ? g1.getName().compareTo(g2.getName()) : temp;
            //比较的方法必须返回整数, 遇到小数时就可用Math.signum符号函数. 大于0就返回1, 小于0就返回-1, 0返回0
            return (int)Math.signum(temp);
*//*            if(temp > 0){
                return 1;
            } else if (temp < 0) {
                return -1;
            }else{
                return 0;
            }*//*
        });*/

        //合并三元运算符, 可简化为:
        Arrays.sort(girlFriends, (g1, g2) -> g1.getAge() != g2.getAge() ? g1.getAge() - g2.getAge()
                                                                        : g1.getHeight() != g2.getHeight() ? (int)Math.signum(g1.getHeight() - g2.getHeight())
                                                                                                           : g1.getName().compareTo(g2.getName()));
        for (int i = 0; i < girlFriends.length; i++) {
            System.out.println(girlFriends[i].getName());
        }
    }
}

class GirlFriend {
    private String name;
    private int age;
    private double height;

    public GirlFriend(String name, int age, double height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }
}

