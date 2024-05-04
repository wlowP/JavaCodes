package wlow03_datastruct_algorithm.datastruct.w1_0_DynamicArray;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 动态数组 (线性表的数组描述) <br>
 * 性能: <br>
 *  - 根据索引访问: O(1) <br>
 *  - 增删: 头部: O(n); 中间: O(n); 尾部: O(1) (跟扩容的情况均摊来说)
 */
public class TestDynamicArray {
    @Test
    @DisplayName("一维动态数组")
    public void DynamicArray() {
        DynamicArray arr = new DynamicArray();

        arr.add(2);arr.add(1);arr.add(4);arr.add(8);arr.add(6);
        arr.add(7);arr.add(11);arr.add(24);arr.add(15);arr.add(9);

        arr.add(3, 0);
        System.out.println(arr.toStringRaw());

        arr.remove(0);
        System.out.println(arr);

        // 继承自Iterable接口的forEach
        // arr.forEach(System.out::println);

        // 自己实现的forEach
        // arr.foreach((num, index) -> System.out.printf("%d: %d\n", index, num));

        // 迭代器遍历
        // for (Integer i : arr) {
        //     System.out.println(i);
        // }

        // 流遍历
        arr.stream().forEach(System.out::println);
    }
}
