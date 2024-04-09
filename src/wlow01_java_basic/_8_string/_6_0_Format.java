package wlow01_java_basic._8_string;

import java.util.Date;

public class _6_0_Format {
    public static void main(String[] args) {
        /* printf类似模板语法, 会用方法后面的参数替换模板字符串中的%开头的占位符
         *  模板字符串中可以有多个%, 对应地printf后要跟一样数目的参数. 📌多了不打印, 少了报错.
         *  一般模板字符串后跟一个\n或%n来换行.
         * */

        // ================数字================

        // *****整数*****
        // 格式化为十进制整数: %d
        System.out.printf("%d ; %d \n", 66L, -66); // 66 ; -66
        // 格式化十进制整数按照一定进制输出: %o %x %X转为大写十六进制
        System.out.printf("%o \n", 111); // 十进制111转成八进制->157
        System.out.printf("%x \n", 111); // 111->6f
        System.out.printf("%X \n", 111); // 111)->6F(大写)

        // *****小数*****
        // 科学计数法输出浮点数: %e %E为大写
        System.out.printf("%e; %E \n", 1428.57, 666.77F); // 1.428570e+03; 6.667700E+02

        // 输出小数: %f 默认保留六位小数, 📌📌会四舍五入
        System.out.printf("%f \n", Math.PI); // 3.141593

        // ================字符串================

        // 格式化字符串: %s %S转为大写
        System.out.printf("%s ; %S \n", "aaa", "aaa"); // aaa ; AAA

        // 格式化布尔值: %b %B转为大写
        System.out.printf("%b ; %B \n", true, false); // true ; FALSE

        // ================其他参数================
        /* 完整格式:
         *  %[argument_index$][flags][width][.precision]conversion
         * */

        // %后面跟n$表示输出可变参数中的第n个参数
        // 想输出"%"就写%%
        System.out.printf("%2$S ; %%%% \n", "aa", "bb"); // BB ; %%

        // , 格式化数字时按照千位用逗号分组. 小数的话只会分组整数部分
        System.out.printf("%,f \n", 11111111.1111); // 11,111,111.111100
        System.out.printf("%,d \n", 1234567); // 1,234,567

        // + 格式化大于等于的0数字时强制加上+号
        System.out.printf("%+d ; %+d ; %+d \n", 0, 123, -123); // +0 ; +123 ; -123

        // %后跟数字m 输出时右对齐, 空缺处补空格.
        System.out.printf("%5s \n", "aa"); //    aa(左边有三个空格)
        // 负数的话左对齐.
        System.out.printf("%-6d\n", 123); // 123   (右边有三个空格)
        // 输入长度大于m的话就一输入长度为准
        System.out.printf("%2s \n", "12345"); // 12345

        // .n 输出小数时限制位数, 📌📌会四舍五入
        System.out.printf("%.3f \n", 1.2345); // 1.235
        System.out.printf("%6.3f", 1.2345); // 1.235  (左边一个空格)

        // ================类似的方法================
        // System.out.format效果一样, 📌printf也是调用了format
        System.out.format("%S \n", "abc"); // ABC
        // String.format形参一样, 返回结果字符串
        String str = String.format("%,d", 1111111);
        System.out.println(str); // 1,111,111

        // ================格式化日期================
        // %t 表示格式化类型为日期. %T为大写.
        /* %t后跟y 表示输出年份(2位数的年份, 2019->19); Y为4位数的年份
        *  m->月份 d->一月中第几天 B->月份的完整名字 b->月份的简称
        * */
        Date d = new Date();
        // 也可以传递Calendar对象
        long time = d.getTime();
        System.out.printf("%1$tY年 ; %1$ty年 \n", d); // 2023年 ; 23年
        // 📌📌还可传递表示时间戳的毫秒数:
        System.out.printf("%1$tm月 ; %1$td日 \n", time); // 02月 ; 02日
        System.out.printf("%1$tB ; %1$tb \n", time); // 二月 ; 2月

        // H->小时数(24进制) I->小时数(12进制) M->分钟数 S->秒数
        System.out.printf("%1$tH : %1$tM : %1$tS \n", d); // 10 : 29 : 55
        // A->星期几的全程 a->星期几的简称
        System.out.printf("%1$tA ; %1$ta \n", d); // 星期四 ; 周四
        // p->上午or下午
        System.out.printf("%tp \n", d); // 上午

        /* 快捷形式: %t后面跟D表示以"%tm/%td/%ty"的形式格式化日期
        *  F->"%tY-%tm-%td" R->"%tH:%tM"
        *  T->"%tH:%tM:%tS" r->"%tI:%tM:%tS %Tp"
        *  c->输出日期的完整信息
        * */
        System.out.printf("%1$tD ; %1$tF \n", d); // 02/02/23 ; 2023-02-02
        System.out.printf("%1$tR ; %1$tr \n", d); // 10:38 ; 10:38:06 上午
        System.out.printf("%tT \n", d); // 10:38:53
        System.out.printf("%tc \n", d); // 周四 2月 02 10:39:38 CST 2023
    }
}