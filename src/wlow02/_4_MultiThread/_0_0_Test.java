package wlow02._4_MultiThread;

public class _0_0_Test {
    public static void main(String[] args) {
        int n;
        int num = 100;
        for (int i = 0; i < 3; i++) {
            if (i == 2){
                System.out.println(num);
            }else{
                n = (int)(num * Math.random());
                System.out.println(n);
                num -= n;
            }
        }
    }
}

