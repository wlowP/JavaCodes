package wlow01_java_basic._3_processControlStatement;

public class _5_0_XSkip7_WIP {
            //[WIP]逢7必过.
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i > 0 && i <= 100 ; i++) {

            //先看看有无7的倍数.有的话直接打印.
            if (i % 7 == 0){
                System.out.println("过!");
                count ++;
                continue;
            }
            //再提取每位数字,看看有无7.有的话打印.
            //while里面i的值会变,先缓存一个
            int tempi = i;
            int v = 1;
            //77跟上面if的重复了, 在条件判断中过滤掉.
            while (i != 0  && i != 77) {
            //数位提取的过程.
                int num = i % 10;
                i /= 10;
                if(num == 7){
                    System.out.println("过!");
                    count ++;
                    v -- ;
                }

            }
            //*重要, 将i恢复为while之前的值,否则会输出0循环
            i = tempi;




        }
        System.out.println("总数:" + count);
    }
}

//范围限定于1~100
/*for (int i = 1; i <= 100; i++){
     if(i % 10 == 7 || i / 10 % 10 == 7 || i % 7 == 0){
        System.out.println("过!");
        continue;
     }



  }
 */