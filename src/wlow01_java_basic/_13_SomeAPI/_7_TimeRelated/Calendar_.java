package wlow01_java_basic._13_SomeAPI._7_TimeRelated;

import java.util.Calendar;

public class Calendar_ {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2001);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 61);
        c.add(Calendar.DATE, 1);
        System.out.println(c.getTime());

        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR, 2000);
        c1.set(Calendar.MONTH, 0);
        c1.set(Calendar.DAY_OF_MONTH, 1);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 61);
        c1.add(Calendar.SECOND, 11);
//        System.out.println(c1.getTime());
    }
}
