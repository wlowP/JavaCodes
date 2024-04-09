package wlow01_java_basic._14_Algorithms;


import java.util.Arrays;

//一些查找算法.
public class _1_Search {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 9, 33, 45, 89, 99, 103, 144, 189, 231};
        System.out.println(binarySearch(arr, 103));
        System.out.println(interpolationSearch(arr, 103));
        System.out.println(fibonacciSearch(arr, 103));
    }

    //基本的二分查找. 数组只能是从小到大排列的.
    public static int binarySearch(int[] arr, int target) {
        int floor = 0, roof = arr.length - 1, mid;
        while (floor <= roof) {
            mid = (floor + roof) / 2;
            if (arr[mid] > target) {
                roof = --mid;
            } else if (arr[mid] < target) {
                floor = ++mid;
            } else if (arr[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    //二分查找改进: 插值查找.
    //适用于数据分布比较均匀的数组. 否则搜索效率反而低于一般二分查找.
    public static int interpolationSearch(int[] arr, int target){
        int floor = 0, roof = arr.length - 1, mid;
        while (floor <= roof){ // 改变mid的算法:
            mid = floor + (target - arr[floor]) / (arr[roof] - arr[floor]) * (roof - floor);
            if (arr[mid] > target) {
                roof = --mid;
            } else if (arr[mid] < target) {
                floor = ++mid;
            } else if (arr[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    //斐波那契查找.
    //先获取斐波那契数列. 这里设置长度为20, 所以搜索的数组长度不超过20.
    public static int[] getFiboArr() {
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
    //查找的方法.
    public static int fibonacciSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        //index表示斐波那契数分割数的下标值
        int index = 0;
        int mid;
        int[] f = getFiboArr();
        while (high > (f[index] - 1)) {
            index++;
        }
        //因为f[index]值可能大于a的长度，因此构造一个temp[]新数组, 复制原来的部分, 多出的部分用原数组的最后一个元素补齐.
        int[] temp = Arrays.copyOf(arr, f[index]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[index - 1] - 1; // <---核心公式
            if (key < temp[mid]) {
                high = mid - 1;
                index--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                index -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
