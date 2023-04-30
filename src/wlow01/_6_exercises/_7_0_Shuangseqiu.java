package wlow01._6_exercises;

import java.util.Random;
import java.util.Scanner;

public class _7_0_Shuangseqiu {
    //双色球.
    public static void main(String[] args) {
        //先创一串随机不重复的数字作为中奖号码.
        int[] win = new int[7];
        Random r = new Random();
        for (int i = 0; i < win.length; ) {
            if (i < win.length - 1) {
                //生成红球中奖号码.
                win[i] = r.nextInt(1, 34);
                //中奖数字重复时跳过本循环.
                if (isExistent(win, win[i], i)) {
                    continue;
                }
                //*****更便捷地防止重复, 可以先独立生成一个随机数(==缓存思想==),
                //*****然后使用在整个数组中判断某数是否存在的方法, 经判断(可用!取反)再决定要不要将该随机数赋给数组.
            } else {
                //生成蓝球中奖号码.
                win[i] = r.nextInt(1, 17);
            }
            i++;
        }
        //(真想玩双色球, 就不要下面这行.)
        traversal(win);

        //然后让幸运儿来输入自己赌的号码.
        int[] bet = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < bet.length; ) {
            if (i < bet.length - 1) {
                System.out.println("请输入红球" + (i + 1) + "的数字>");
                bet[i] = sc.nextInt();
                //防止输入的数字超出范围.
                if (bet[i] < 1 || bet[i] > 33) {
                    System.out.println("数字超出范围!请重新输入!");
                    continue;
                    //防止输入的数字重复.
                    //*****这里同样可以先把输入的数字缓存在一个临时变量, 不着急直接赋予数组,
                    //*****然后使用在整个数组中判断某数是否存在的方法, 经判断(可用!取反)再决定要不要将该随机数赋给数组.
                } else if (isExistent(bet, bet[i], i)) {
                    System.out.println("红球当中已经输入过此数字了!请重新输入!");
                    continue;
                }
            } else {
                System.out.println("请输入蓝球的数字>");
                bet[i] = sc.nextInt();
                if (bet[i] < 1 || bet[i] > 16) {
                    System.out.println("数字超出范围!请重新输入!");
                    continue;
                }
            }
            i++;
        }
        traversal(bet);

        //接着判断是否中奖, 统计中奖的球的个数.
        int red = 0;
        int blue = 0;
        for (int i = 0; i < win.length; i++) {
            if (i < win.length - 1) {
                //if(bet[i] == win[i]) {red++;}
                int num = bet[i];
                for (int j = 0; j < win.length - 1; j++) {
                    if (num == win[j]) {
                        red++;
                        break;
                    }
                }
            } else {
                if (bet[i] == win[i]) {
                    blue++;
                }
            }
        }
        //(统计结果是a*10+b的组合形式)
        int result = red * 10 + blue;
        System.out.println("红:" + red);
        System.out.println("蓝:" + blue);

        //最后看看幸运儿手气好不好.
        switch (result) {
            default:
                System.out.println("很遗憾, 您并没有中奖┭┮﹏┭┮, 欢迎下次再来!");
                break;
            case 1:
            case 11:
            case 21:
                System.out.println("恭喜您中了六等奖!奖金为:5.00元!");
                break;
            case 31:
            case 40:
                System.out.println("恭喜您中了五等奖!奖金为:10.00元!");
                break;
            case 41:
            case 50:
                System.out.println("恭喜您中了四等奖!奖金为:200.00元!");
                break;
            case 51:
                System.out.println("恭喜您中了三等奖!奖金为:3000.00元!");
                break;
            case 60:
                System.out.println("牛哇, 您中了二等奖!奖金最高500万!");
                break;
            case 61:
                System.out.println("太牛了!您居然中了一等大奖!奖金最高1000万!");
                break;
        }

    }


    /*------------------------------------------*/
    public static void traversal(int[] arr1) {
        //遍历数组.
        System.out.print("[");
        for (int i = 0; i < arr1.length; i++) {

            if (i < arr1.length - 1) {
                System.out.print(arr1[i] + ", ");
            } else {
                System.out.println(arr1[i] + "]");
            }
        }
    }

    //用来检测赋予的随机数据是否重复的方法:
    public static boolean isExistent(int[] arr, int a, int b) {
        for (int i = 0; i < b; i++) {
            if (a == arr[i]) {
                return true;
            }
        }
        return false;
    }
}
