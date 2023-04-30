package wlow01._2_calculation;

public class _7_LogicOperator {
    public static void main(String[] args) {
        //且
        System.out.println(200 & 8); //T
        System.out.println(true & false); //F
        //或
        System.out.println(false | false); //F
        System.out.println(false | true); //T
        //异或  (禁止同性恋)
        System.out.println(true ^ true); //F
        System.out.println(false ^ false); //F
        System.out.println(true ^ false); //T
        //取反
        System.out.println(!true); //F
        System.out.println(!!true); //T  (双重否定)

    }
}
