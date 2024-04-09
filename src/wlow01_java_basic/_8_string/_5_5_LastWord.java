package wlow01_java_basic._8_string;

public class _5_5_LastWord {

    //对于输入的字符串, 从后往前检测第一个出现的单词, 并返回其长度.
    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要检测的字符串>");*/
        String say = "I love creeper.";

        String lastWord = lastWordLen(say);
        System.out.println("最后一个单词是: " + lastWord + ", 其长度为: " + lastWord.length());
    }



    //从后往前检测第一个出现的单词, 并返回其长度.
    public static String lastWordLen(String str){
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
                sb.append(c);
                flag = true;
            }
            if(flag){
                if(c == 32){break;}
            }
        }
        return sb.reverse().toString();
    }
}
