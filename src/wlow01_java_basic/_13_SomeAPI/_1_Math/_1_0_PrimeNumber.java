package wlow01_java_basic._13_SomeAPI._1_Math;

public class _1_0_PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime(9));
    }

    public static boolean isPrime(int num){
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
