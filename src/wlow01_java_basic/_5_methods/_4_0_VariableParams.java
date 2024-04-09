package wlow01_java_basic._5_methods;

// 可变参数
public class _4_0_VariableParams {
    public static void main(String[] args) {
        // 格式: 数据类型...变量名
        System.out.println(sum(1, 2, 3, 4, 5)); // 15

        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(sum(nums)); // 21
    }

    public static int sum(int...nums){
        System.out.println(nums[4]); // 5
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
