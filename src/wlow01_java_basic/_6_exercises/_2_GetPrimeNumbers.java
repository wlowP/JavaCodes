package wlow01_java_basic._6_exercises;

public class _2_GetPrimeNumbers {

    public static void main(String[] args) {
        int count = 0;
        for(int i = 100 ; i <= 200 ; i++){
            boolean v = true;
            for (int i1 = 2; i1 <= Math.pow(i, 0.5); i1++) {
                if (i % i1 == 0){
                    v = false;
                    break;
                }
            }
            if (v){
                System.out.println(i);
            }
            count += (v ? 1 : 0);
        }
        System.out.println("总共有" + count + "个质数.");
    }


}
