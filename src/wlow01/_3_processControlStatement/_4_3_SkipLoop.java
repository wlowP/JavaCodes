package wlow01._3_processControlStatement;

public class _4_3_SkipLoop {
            //跳过循环
    public static void main(String[] args) {

/*        for (int i = 1; i <= 7 ; i ++ ){
            //continue 跳过某一次循环.
            if (i == 4){
                continue;
            }
            System.out.println(i);
        }

        System.out.println("------------------------");

        for (int i = 1; i <= 7 ; i ++ ){
            //break 在某一次循环终止.
            //此时打印结果要移到if上面,把终止处的结果也打印出来.
            System.out.println(i);
            if (i == 4){
                break;
            }

        }*/

        int a = 1;
        while (a <= 10){

            if (a == 7){
                continue;
            }
            System.out.println(a);
            a ++;

        }

    }
}
