package wlow01._13_SomeAPI._7_TimeRelated;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat();
        Date d = new Date(0);
        System.out.println(df.format(d)); // 默认格式

        //自定义格式:
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日, HH:mm:ss, E"); // 输出
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); // 接收
        //System.out.println(df1.format(d));

        String date = "2099-12-12";
        Date d1 = df2.parse(date);
        System.out.println(df1.format(d1) + " " +  d1.getTime());

        System.out.println("=============================");
        SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        String dateL = "2023-11-11 0:0:0";
        String dateR = "2023-11-11 0:10:0";
        long L = df3.parse(dateL).getTime();
        long R = df3.parse(dateR).getTime();

        String dateIn = "2023-11-11 0:10:11";
        long T = df3.parse(dateIn).getTime();
        System.out.println((T >= L && T <= R));

    }
}
