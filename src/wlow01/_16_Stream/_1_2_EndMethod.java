package wlow01._16_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

// Stream流的终结方法
public class _1_2_EndMethod {
    public static void main(String[] args) {
        // forEach
        ArrayList<String> list = new ArrayList<>(List.of("aa", "bb", "cc", "dd"));
        list.stream().forEach(str-> System.out.print(str + " ")); // aa bb cc dd
        // 上一行的效果跟 list.forEach(...)一样

        System.out.println("\n===========");

        // count对处理完后的流中的元素计数
        System.out.println(list.stream().count()); // 4

        System.out.println("===========");

        // toArray方法: 📌📌不传递参数的话默认返回Object类型的数组
        // IntFunction的泛型: 要写具体类型的数组(T[] arr)
        // apply方法的形参: 流中数据的个数
        // apply方法返回值类型: T[]
        // apply方法体: 创建T类型的数组
        String[] strs = list.stream().map(s-> s + "6").toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                System.out.println(value); // 4
                return new String[value];
            }
            /*IntFunction的实现类负责创建一个指定类型的数组,
            * toArray方法依次把流里面每一个数据放到该数组当中
            * 然后toArray方法再将该数组返回.
            * */
        });
        System.out.println(Arrays.toString(strs)); // [aa6, bb6, cc6, dd6]

        // 用lambda表达式:
        String[] strs1 = list.stream().map(s-> s + "6").toArray(value -> new String[value]);
        System.out.println(Arrays.toString(strs1)); // [aa6, bb6, cc6, dd6]

        System.out.println("===========");
    }
}
