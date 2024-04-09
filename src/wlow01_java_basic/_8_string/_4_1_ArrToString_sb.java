package wlow01_java_basic._8_string;

public class _4_1_ArrToString_sb {
            //利用StringBuilder将数组转换为字符串.
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        System.out.println(arr2String(arr));
    }

    public static String arr2String(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length -1){
                sb.append(arr[i] + ", ");
            }else{
                sb.append(arr[i] + "]");
            }
        }
        return sb.toString();
    }
}
