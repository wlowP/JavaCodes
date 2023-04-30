package wlow01._13_SomeAPI._6_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _4_CaptureAndName {
    public static void main(String[] args) {

        // 捕获不分组(不加小括号):
        Pattern pat = Pattern.compile("\\d{4}");
        String str = "abc1234ll,   6666,';.[;!@#$%^17| 7890";
        Matcher m = pat.matcher(str);
        /* 底层原理:
        *  matcher对象里有一个数组: int[] groups
        *  每当find方法找到时, 数组中的📌前两项📌就记录匹配到的字符串的起始索引和结束索引+1
        *  并且find方法内将查找指针移到结束索引+1的位置, 下一次从此查找
        *  不分组(不加小括号)的话只会改变groups数组的前两项.
        * */
        while (m.find()){
            System.out.print(m.group() + " ");
        } // 1234 6666 7890
        System.out.println();


        // 捕获并分组(加小括号分组)
        Pattern pat1 = Pattern.compile("(\\d\\d)(\\d\\d)");
        Matcher m1 = pat1.matcher(str);
        /* 一对小括号为一组, 组号以左括号为基准. 第n个左括号就是第n组
        *  matcher的groups数组的前两项仍然是记录匹配到的字符串的起始索引和结束索引+1
        *  但是数组的[2], [3]会记录第一个分组子串的起始, 末尾+1
        *  [4], [5]记录第二个分组...
        *  [2n], [2n+1]记录第n个分组的位置.
        *
        *  用group(n) 方法获取捕获到的内容时, 📌📌会根据groups数组返回捕获到的子串截取索引groups[2*n]到groups[2*n+1]的部分.
        *  就是对应了捕获到的整个子串(n=0)和其中第n个分组(n>=1)的位置.
        *  📌有分组的话, group(0)->捕获到的整个子串, group(m>=1)->第m个分组
        *  📌无参的话n默认为0.
        *
        *  以(\d\d)(\d\d)捕获到1234为例, group(0)就是1234, group(1)=12, group(2)=34
        * */
        while (m1.find()){
            System.out.println("捕获到的整体: " + m1.group(0) + ", 分组一: " + m1.group(1) + ", 分组二: " + m1.group(2));
        }



        // 捕获分组并命名:
        Pattern pat2 = Pattern.compile("<p class=\"(?<className>.*?)\">(?<content>.*?)</p>");
        String str1 = "<p class=\"box\">This is a P tag</p> <p class=\"div\">This is antoher P tag</p>";
        Matcher m2 = pat2.matcher(str1);
        while (m2.find()){
            System.out.println("匹配整体内容: " + m2.group());
            System.out.println("分组className: " + m2.group("className"));
            System.out.println("分组content: " + m2.group("content"));
        }

    }
}
