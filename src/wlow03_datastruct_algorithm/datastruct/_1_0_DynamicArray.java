package wlow03_datastruct_algorithm.datastruct;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组 (线性表的数组描述)
 * 性能:
 *  - 根据索引访问: O(1)
 *  - 增删: 头部: O(n); 中间: O(n); 尾部: O(1) (跟扩容的情况均摊来说)
 */
public class _1_0_DynamicArray {
    public static void main(String[] args) {
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

class DynamicArray implements Iterable<Integer>{
    // 数组实际大小, 同时也是指向新元素应当插入的末尾位置
    private int size;
    // 数组最大容量
    private int capacity = 8;
    // 底层数组. 初始容量为0, 只有在第一次添加数据时才会被初始化. 初始化容量为8
    private int[] data = {};

    /**
     * 向数组尾部插入新元素
     * @param element 要插入的元素值
     */
    public void add(int element) {
        add(size, element);
    }

    /**
     * 向数组指定索引位置插入元素
     * @param index 要插入的索引位置
     * @param element 要插入的元素值
     */
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        // 容量检查
        if (size == 0) initialize();
        else if (size == capacity) grow();

        // 如果不是在尾部插入, 先将部分元素后移再插入新元素
        if (index < size) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = element;
        size++;
    }

    /**
     * 获取指定索引位置的元素
     * @param index 要获取的元素索引位置
     * @return 对应索引位置的元素
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return data[index];
    }

    /**
     * 删除指定索引位置的元素
     * @param index 要删除的索引位置
     * @return 被删除的元素值
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int target = data[index];
        // 如果删除的不是末尾元素, 先将部分元素往前移动
        if (index < size - 1) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
        }
        size--;
        return target;
    }

    /**
     * 数组扩容. 容量增为原来的1.5倍 <br>
     *  - 📌<b>得益于Java的垃圾回收机制, 在这里不用显式地删除旧的数组</b>
     */
    private void grow() {
        capacity += capacity >> 1;
        int[] newData = new int[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * 初始化数组
     */
    private void initialize() {
        data = new int[capacity];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }

    /**
     * 展示底层的原始数组
     */
    public String toStringRaw() {
        return Arrays.toString(data);
    }

    /**
     * <h2>遍历方式1 - foreach + {@link Consumer}</h2>
     * 遍历方法只提供参数, 具体的行为靠传入的Consumer实现类对象来决定 <br>
     * 方法命名为foreach是为了防止跟遍历方式2中继承自 {@link Iterable} 接口的默认方法 <br>
     * {@link Iterable#forEach} 冲突
     * @param consumer 遍历时要对数组中每一项进行的行为
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }

    /**
     * <b>遍历方式1加上了索引的版本</b>
     * @param biConsumer 遍历时要对每一项及其索引值进行的行为
     */
    public void foreach(BiConsumer<Integer, Integer> biConsumer) {
        for (int i = 0; i < size; i++) {
            biConsumer.accept(data[i], i);
        }
    }

    /**
     * <h2>遍历方式2 - 迭代器遍历</h2>
     * 该类要先实现 {@link Iterable<>} 接口, 然后实现其中的iterator方法<br>
     * 自己构造并返回一个迭代器对象 <br>
     * 实现了迭代器遍历以后就能用增强的for遍历了
     * @return 迭代器对象
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int i = 0; // 自己构造的迭代器对象, 自己指定索引

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return data[i++];
            }
        };
    }

    /**
     * <h2>遍历方式3 - Stream流遍历</h2>
     * @return stream流对象
     */
    public IntStream stream() {
        return IntStream.of(Arrays.copyOf(data, size));
    }
}