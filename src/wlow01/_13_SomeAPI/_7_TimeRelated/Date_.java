package wlow01._13_SomeAPI._7_TimeRelated;

import java.util.Date;

public class Date_ {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);
        d1.setTime(9000000000000L);
        System.out.println(d1);
    }
}
