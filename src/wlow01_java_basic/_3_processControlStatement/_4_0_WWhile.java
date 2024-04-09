package wlow01_java_basic._3_processControlStatement;

public class _4_0_WWhile {
    public static void main(String[] args) {
        /*基本格式
        int i = 1;
        while(i <= 100){

            System.out.println(i);
            i ++ ;

        }*/

        //**一张0.1毫米白纸折多少次才能有珠穆朗玛峰那么高?
        int count = 0;
        //运用while
        double h = 0.1;

        while(h <= 8848860 ){

            h *= 2;
            count ++;

        }

        //运用for
/*        for(double h = 0.1 ; h <= 8848860 ; h *= 2){
            count += 1;
        }*/
        System.out.println(count);
    }
}
