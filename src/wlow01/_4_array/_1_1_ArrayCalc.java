package wlow01._4_array;

public class _1_1_ArrayCalc {
            //遍历的应用.
    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};

        //数组求和.
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
            sum += arr1[i];
        }
        System.out.println("求和:" + sum);


        //数组中统计能被3整除的元素.
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] % 3 ==0){
                count ++;
            }
        }
        System.out.println("能被3整除的数共有" + count + "个.");

        //数组中对特定的元素进修改.
        for (int i = 0; i < arr1.length; i++) {

            //数组中的奇数扩大两倍, 偶数缩小一半.
            if (arr1[i] % 2 ==1){
                arr1[i] *= 2;
            }else{
                arr1[i] /= 2;
            }
            //一个循环尽量不要做太多事, 一件事就好.
            System.out.println(arr1[i]);

        }


    }
}
