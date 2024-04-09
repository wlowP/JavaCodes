package wlow01_java_basic._4_array;

import java.util.Random;

//打乱一维数组并存放到二维数组中.
public class _3_1_NumDisarrange_2D {
    public static void main(String[] args) {
        Random r = new Random();
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] arr1 = new int[16];
        //IDEA提示的复制数组方法.
        System.arraycopy(tempArr, 0, arr1, 0, arr1.length);
        for (int i = 0; i < tempArr.length; i++) {
            int ranIndex = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[ranIndex];
            tempArr[ranIndex] = temp;
        }
        int[][] arr = new int[4][4];
/*        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 4; i1++) {
                arr[i][i1] = tempArr[index];
                index ++;
            }
        }*/

        //*****更妙的二维数组循环赋值办法.
        for (int i = 0; i < tempArr.length; i++) {
            arr[i / 4][i % 4] = tempArr[i];
        }

/*        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                System.out.print(arr[i][i1] + ", ");
            }
            System.out.println();
        }*/

         for(int i1 = 0; i1 < arr.length; i1++){
             for(int i2 = 0; i2 < arr[i1].length; i2++){
                 if(i2 == 0){
                     System.out.print(arr[i1][i2]);
                     continue;
                 }
                 System.out.print(" " + arr[i1][i2]);
             }
             System.out.println();
         }
    }
}
