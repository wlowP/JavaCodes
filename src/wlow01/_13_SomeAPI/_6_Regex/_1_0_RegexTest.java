package wlow01._13_SomeAPI._6_Regex;

public class _1_0_RegexTest {
    public static void main(String[] args) {
        String pattern1 = "\\??";
        System.out.println("?".matches(pattern1));
        System.out.println("a".matches(pattern1));
        System.out.println("a".matches("a*"));
        String str = "我不不不知知知知知知知道道道道道道道道道道道道.";
        //在正则表达式外面获取捕获的字符组.
        System.out.println(str.replaceAll("(.)\\1+", "$1"));
    }
}
