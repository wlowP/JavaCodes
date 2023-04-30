package wlow01._4_array;

public class _1_0_ArrayBasic {
    public static void main(String[] args) {
        //定义数组.(静态初始化)
        int[] arr1 = {1, 2, 3, 4, 5};
        String[] arr2 = {"熊大", "熊二", "光头强", "翠花"};
        double[] arr3 = {1.1, 2.2, 3.3, 4.4, 5.5};

        //System.out.println(arr3); //[D@776ec8df

        //数组的索引:
        //索引的排列序号是从0开始逐个+1的.
/*        int a = arr1[0];
        System.out.println(a); //1
        System.out.println(arr1[0]); //1*/

        //改变数组中某元素的值:
/*        arr3[1] = 11.1;
        System.out.println(arr3[1]); //11.1*/

        //循环打印数组中的元素:
      /*  for (int i = 0; i <= 3; i++) {
            System.out.println(arr2[i]);
        }*/

        //获取数组的长度.便捷进行数组遍历.
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
}
