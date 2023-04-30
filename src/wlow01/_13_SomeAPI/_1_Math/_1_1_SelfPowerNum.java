package wlow01._13_SomeAPI._1_Math;

import java.util.ArrayList;

        //判断指定范围内数字是不是自幂数.
public class _1_1_SelfPowerNum {
    public static void main(String[] args) {
        int count = 0;
        long start = System.currentTimeMillis();
        for (int i = 1000; i <= 999999; i++) {
            if (ifSelfPower(i)){
                count++;
            }
        }
        System.out.println(count);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("===============================");
        int count1 = 0;
        long start1 = System.currentTimeMillis();
        for (int i = 1000; i <= 999999; i++) {
            if (isSelfPower(i)){
                count1++;
            }
        }
        System.out.println(count1);
        System.out.println(System.currentTimeMillis() - start1);
    }

    public static boolean isSelfPower(int num){
        ArrayList<Integer> list = new ArrayList<>();
        int power = 0, tempNum = num, sum = 0;
        while (num > 0){
            list.add(num % 10);
            num /= 10;
            power++;
        }
        for (int i = 0; i < list.size(); i++) {
            sum += Math.pow(list.get(i), power);
        }
        return sum == tempNum;
    }

    //效率更高的方法.
    public static boolean ifSelfPower(int num){
        String numStr = Integer.toString(num);
        int power = numStr.length(), sum = 0;
        for (int i = 0; i < power; i++) {
            sum += Math.pow(numStr.charAt(i) - 48, power);
        }
        return sum == num;
    }
}
