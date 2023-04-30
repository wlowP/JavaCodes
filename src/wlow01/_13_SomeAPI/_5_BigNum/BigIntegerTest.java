package wlow01._13_SomeAPI._5_BigNum;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("9223372036854775808"); //2^63
        BigInteger bi1 = new BigInteger("18446744073709551616"); //2^64
        //超过整数范围时别忘了加L.
        BigInteger bi2 = BigInteger.valueOf(8589934592L);
        System.out.println(bi + "\n" + bi2);

        System.out.println(bi.subtract(bi2));
        BigInteger[] arr = bi.divideAndRemainder(bi2);
        //数组里先后是商, 余数.
        System.out.println(arr[0] + "\n" + arr[1]);
        BigInteger bi3 = new BigInteger("1899");
        System.out.println(101 + bi3.intValue());
    }
}
