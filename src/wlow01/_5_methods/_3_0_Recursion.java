package wlow01._5_methods;


        //初步体验递归.
public class _3_0_Recursion {
    public static void main(String[] args) {
        System.out.println(sum(5) + "\n" + factorial(5));

//        transform(789789789);
    }

    //用递归实现求和. (从1加到n)
    public static int sum(int n){
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    //用递归实现阶乘. (从1乘到n)
    public static int factorial(int n){
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    //用递归把数字从小写转为大写(中文)
    public static void transform(int n){
        if (n < 10) {
            System.out.print(digToWord(n));
        }else{
            //以下两句顺序调换的话就会逆序转换.
            transform(n / 10);
            System.out.print(digToWord(n % 10));
        }
    }
    public static String digToWord(int n){
        return switch (n){
            case 0 -> "零";
            case 1 -> "一";
            case 2 -> "二";
            case 3 -> "三";
            case 4 -> "四";
            case 5 -> "五";
            case 6 -> "六";
            case 7 -> "七";
            case 8 -> "八";
            case 9 -> "九";
            default -> "";
        };
    }
}
