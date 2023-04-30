package wlow01._6_exercises;


import java.util.Scanner;

public class _4_Score {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] osc = new int[6];
        for (int i = 0; i < osc.length;i++) {
            System.out.println("请输入第" + (i+1) + "个评委给的分数>");
            osc[i] = sc.nextInt();
            if (osc[i] > 100 || osc[i] < 0){
                System.out.println("这分数不合理!");
                //***通过下面一步来循环输入, 直到输入正确为止.[也可以将条件控制语句i++移到if结束之后, 再将i--改为continue]
                i--;
            }
        }
        int max = osc[0];
        for (int i = 1; i < osc.length; i++) {
            max = max > osc[i] ? max : osc[i] ;
        }
        int min = osc[0];
        for (int i = 0; i < osc.length; i++) {
            min = min < osc[i] ? min : osc[i] ;
        }
        int sum = 0;
        for (int i = 0; i < osc.length; i++) {
            sum += osc[i];
        }
        int average = ((sum - max - min)/(osc.length - 2));
        System.out.println("最终平均分:" + average);

    }
}
