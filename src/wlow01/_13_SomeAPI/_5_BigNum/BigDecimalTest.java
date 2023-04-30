package wlow01._13_SomeAPI._5_BigNum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
        //直接给小数的话还是有误差.
        BigDecimal bd1 = new BigDecimal(0.21);
        //System.out.println(bd1); //0.2099999999999999922284388276239042170345783233642578125

        BigDecimal bd2 = BigDecimal.valueOf(0.90);
        System.out.println(bd2); //0.9

        BigDecimal bd3 = new BigDecimal("0.3");
        BigDecimal bd4 = new BigDecimal("0.33");
        System.out.println(bd2.divide(bd3)); //3
        System.out.println(bd2.divide(bd4, 5, RoundingMode.HALF_UP)); //2.72727
    }
}
