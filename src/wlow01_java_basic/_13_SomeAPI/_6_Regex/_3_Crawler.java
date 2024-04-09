package wlow01_java_basic._13_SomeAPI._6_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _3_Crawler {
    public static void main(String[] args) {
        String str = "abbbbbbbbbb电话: 18512516758, 18512508907, 联系邮箱:boniu@itcast.cn, bozai@itcast.cn.mm, 座机电话: 01036517895, 010-98951256, 热线电话: 400-618-9090, 400-618-4000, 4006184000, 4006189090";
        Pattern phone = Pattern.compile("[1-9]\\d{10}");
        Pattern mail = Pattern.compile("[\\w&&[^_]]+@[\\w&&[^_]]+(\\.[\\w&&[^_]]+)+");
        Pattern landline = Pattern.compile("010-?\\d{8}");
        Pattern hotline = Pattern.compile("400-?618-?\\d{4}");

        Pattern pt = Pattern.compile("[1-9]\\d{10}|[\\w&&[^_]]+@[\\w&&[^_]]+(\\.[\\w&&[^_]]+)+|010-?\\d{8}|400-?618-?\\d{4}");

//        Matcher m = phone.matcher(str);
//        print(m);
//        m = mail.matcher(str);
//        print(m);
//        m = landline.matcher(str);
//        print(m);
//        m = hotline.matcher(str);
//        print(m);

        Matcher m = pt.matcher(str);
        print(m);
    }

    private static void print(Matcher m) {
        while (m.find()){
            System.out.println(m.group());
        }
    }


}
