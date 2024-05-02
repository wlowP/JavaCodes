package wlow03_datastruct_algorithm.datastruct;

import java.util.Iterator;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 链表 (线性表的链式描述) <br>
 * 性能: <br>
 *  - 根据索引访问: O(n) <br>
 *  - 增/删: 末尾位置: 已知尾节点 -> O(1), 否则O(n); <br>
 *          起始位置: O(1); 中间位置: O(n)
 */
public class _1_1_LinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        System.out.println(list);

        list.remove(0);

        System.out.println(list);

        list.add(3, 9);

        System.out.println(list);

        // list.foreach(System.out::println);

        // for (Integer i : list) {
        //     System.out.println(i);
        // }

        list.stream().forEach(System.out::println);
    }
}

/**
 * <h1>单向链表 SinglyLinkedList</h1>
 */
class SinglyLinkedList implements Iterable<Integer>{
    // 链表的头节点
    private Node head;

    public SinglyLinkedList() {}

    /**
     * 向链表头部新加入一个节点
     * @param element 要加入的元素
     */
    public void addFirst(int element) {
        /*Node node = new Node(element, null);
        if (head != null) {
            node.next = head;
        }
        head = node;*/
        // 代码可以被大幅简化...🤣🤣🤣
        head = new Node(element, head);
    }

    /**
     * 向链表指定索引位置插入一个节点
     * @param element 要插入的节点值
     * @param index 要插入的索引位置
     */
    public void add(int index, int element) {
        if (index == 0) {
            addFirst(element);
            return;
        }

        // 先找到插入位置的前一个节点
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IndexOutOfBoundsException();
        }

        prev.next = new Node(element, prev.next);
    }

    /**
     * 向链表尾部位置添加一个节点
     * @param element 添加的节点值
     */
    public void add(int element) {
        Node last = findLastNode();
        if (last == null) {
            addFirst(element);
            return;
        }
        last.next = new Node(element, null);
    }

    /**
     * 删除第一个节点. <br>
     * 📌<b>得益于Java的垃圾回收机制, 在这里不用显式地删除第一个节点</b>
     */
    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    /**
     * 根据指定索引位置删除对应节点 <br>
     * 📌<b>得益于Java的垃圾回收机制, 在这里不用显式地删除目标节点</b>
     * @param index 要删除的节点的索引值
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        // 先找到目标节点的前一个节点
        Node prev = findNode(index - 1);
        if (prev == null || prev.next == null) {
            throw new IndexOutOfBoundsException();
        }

        prev.next = prev.next.next;
    }

    /**
     * 根据索引值查找并返回对应节点对象. 找不到时返回null
     * @param index 要查找的索引
     * @return 索引值对应的节点或者null
     */
    private Node findNode(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node cur = head;
        int i = 0;
        while (cur != null && i < index) {
            cur = cur.next;
            i++;
        }
        return cur;
    }

    /**
     * 查询并返回尾部节点对象
     * @return 尾部节点对象
     */
    private Node findLastNode() {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * <h3>节点内部类. </h3>
     * 因为Node可以不依附于外部的链表结构而存在 <br>
     * 也不需要访问外部类的非静态成员, 所以定义为静态内部类
     */
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Node cur = head;
        while (cur != null) {
            sj.add(String.valueOf(cur.value));
            cur = cur.next;
        }
        return sj.toString();
    }

    /**
     * <h2>遍历方式1 - foreach + {@link Consumer}</h2>
     * @param consumer 遍历时要对链表中每一项进行的行为
     */
    public void foreach(Consumer<Integer> consumer) {
        Node cur = head;
        while (cur != null) {
            consumer.accept(cur.value);
            cur = cur.next;
        }
    }

    /**
     * <h2>遍历方式2 - 迭代器</h2>
     * @return 迭代器对象
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node cur = head;
            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Integer next() {
                int val = cur.value;
                cur = cur.next;
                return val;
            }
        };
    }

    /**
     * <h2>遍历方式3 - Stream流</h2>
     * @return Stream流对象
     */
    public Stream<Integer> stream() {
        Stream.Builder<Integer> builder = Stream.builder();
        Node cur = head;
        while (cur != null) {
            builder.add(cur.value);
            cur = cur.next;
        }
        return builder.build();
    }
}