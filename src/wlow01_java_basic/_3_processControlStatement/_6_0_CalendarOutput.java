package wlow01_java_basic._3_processControlStatement;

import java.util.Calendar;
import java.util.Scanner;

    //输入阿拉伯数字表示月份, 输出2019年该月的日历以及下一个月的日历.
    //横排输出.
public class _6_0_CalendarOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c.set(2019, Calendar.JANUARY, 1, 1, 1, 1);
        c1.set(2019, Calendar.JANUARY, 1, 1, 1, 1);
        int month = sc.nextInt() - 1;
        String[] months = {"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月", "12月"};
        c.set(Calendar.MONTH, month);
        if (month == 11) c1.set(Calendar.MONTH, month);
        else c1.set(Calendar.MONTH, month + 1);
        System.out.println("\t\t2019年 " + months[month] + "\t\t\t||  \t\t2019年 " + months[month + 1] + "\t\t\t||  \n一\t二\t三\t四\t五\t六\t日\t||  一\t二\t三\t四\t五\t六\t日\t||");
        int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH), actDay = 1;
        int maxDay1 = c1.getActualMaximum(Calendar.DAY_OF_MONTH), actDay1 = 1;
        for (int i1 = 0; i1 < 6; i1++) {
            if (actDay == maxDay + 1 && actDay1 == maxDay1 + 1){break;}
            for (int i = 0; i < 7 ; i++){
                int act = c.get(Calendar.DAY_OF_WEEK);
                if (actDay == maxDay + 1){
                    for(int j = 0; j < 7 - i; j++)System.out.print("\t");
                    System.out.print("||  ");
                    break;
                }
                if(act == i + 2 || act == i - 5)
                    System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");
                else{
                    System.out.print("\t");
                    continue;
                }
                if (i == 6) System.out.print("||  ");
                c.add(Calendar.DAY_OF_MONTH, 1);
                actDay++;
            }
            for (int i = 0; i < 7 ; i++){
                int act = c1.get(Calendar.DAY_OF_WEEK);
                if (actDay1 == maxDay1 + 1){
                    System.out.println();
                    break;
                }
                if(act == i + 2 || act == i - 5) {
                    System.out.print(c1.get(Calendar.DAY_OF_MONTH) + "\t");
                }else{
                    System.out.print("\t");
                    continue;
                }
                if (i == 6)System.out.println("||  ");
                c1.add(Calendar.DAY_OF_MONTH, 1);
                actDay1++;
            }
        }
    }
}
