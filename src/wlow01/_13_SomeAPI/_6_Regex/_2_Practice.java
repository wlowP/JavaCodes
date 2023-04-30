package wlow01._13_SomeAPI._6_Regex;

public class _2_Practice {
    public static void main(String[] args) {
        String patUName = "\\w{4,16}";
        String patID_s = "[1-9]\\d{16}[\\dXx]";
        String patID = "[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|(?i)x)"; //Xx

        String UName = "wlow01";
        String ID = "66666619191225008X";

        System.out.println(UName.matches(patUName));
//        System.out.println(ID.matches(patID_s));
        System.out.println(ID.matches(patID));
    }
}
