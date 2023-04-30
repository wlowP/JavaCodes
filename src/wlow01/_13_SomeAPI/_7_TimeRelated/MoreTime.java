package wlow01._13_SomeAPI._7_TimeRelated;

import java.time.*;

public class MoreTime {
    public static void main(String[] args) {
        //国际标准时间, 不带时区.
        Instant i = Instant.now();
        System.out.println(i);

        //设置一个时区.
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(time);

        LocalDate ld = LocalDate.of(2099, 1, 20);
        System.out.println(ld);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

    }
}
