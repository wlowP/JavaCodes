package wlow01_java_basic._8_string;

public class _5_1_HeadToEnd {
            //字符串的旋转.
            //重复将字符串的首位字符移到末尾, 判断能不能与另外一个字符串相同.
    public static void main(String[] args) {
        String A = "abcde";
        String B = "bcdea";
        boolean v = true;
        for (int i = 0; i < A.length() ; i++) {
            if (A.equals(B)) {
                System.out.println("True");
                v = false;
                break;
            }else{
                A = head2End(A);
            }
        }
        if (v){
            System.out.println(!v);
        }
        //9~21行创建方法做的话会更好.

    }


    //将字符串的首位字符移到末尾的方法.
    public static String head2End(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(1)).append(str.charAt(0));
        return sb.toString();
    }
}
