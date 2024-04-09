package wlow02_java_advance._2_Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _1_0_Basic {
    public static void main(String[] args) throws ParseException {
        // 编译时异常 (出现在编译阶段, 必须手动处理(加上throws语句), 否则代码还没运行就会报错)
        String date = "2023年1月31日";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date d = sdf.parse(date);
        System.out.println(d);

        // 运行时异常 (可以通过编译阶段, 在代码运行阶段才会出现)
        String[] arr = {"aa", "bb", "cc"};
        System.out.println(arr[99]); // 运行时抛出:ArrayIndexOutOfBoundsException

    }
}
