package wlow03_datastruct_algorithm.datastruct.w1_1_LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * <h1>双向带哨兵链表 - 环形链表</h1>
 * 仅有一个哨兵节点, 初始时既是头部节点也是尾部节点. <br>
 * 链表的尾部节点的next指向头部哨兵节点; 哨兵节点的prev指向尾部节点.
 */
public class DoublyLinkedListSentinelCircular implements Iterable<Integer> {

    private final Node sentinel = new Node(null, 0, null);

    /**
     * <h3>初始状态, 哨兵节点既是头节点也是尾节点</h3>
     */
    public DoublyLinkedListSentinelCircular() {
        sentinel.prev = (sentinel.next = sentinel);
    }

    /**
     * 根据索引获取对应元素, 找不到时抛异常 <br>
     * <b>这里不直接复用 {@link #findNode} 是因为findNode允许返回索引为-1的哨兵节点</b>
     * @param index 索引值
     * @return 索引值对应的元素
     */
    public int get(int index) {
        Node cur = sentinel.next;
        int i = 0;
        while (cur.next != sentinel && i < index) {
            cur = cur.next;
            i++;
        }
        if (i == index) {
            return cur.value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 向链表头部新加入一个节点
     * @param value 要加入的元素
     */
    public void addFirst(int value) {
        sentinel.next = (sentinel.next.prev = new Node(sentinel, value, sentinel.next));
    }

    /**
     * 向链表尾部位置添加一个节点
     * @param value 添加的节点值
     */
    public void add(int value) {
        sentinel.prev = (sentinel.prev.next = new Node(sentinel.prev, value, sentinel));
    }

    /**
     * 向链表指定索引位置插入一个节点
     * @param value 要插入的节点值
     * @param index 要插入的索引位置
     */
    public void add(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IndexOutOfBoundsException();
        }
        prev.next = (prev.next.prev = new Node(prev, value, prev.next));
    }

    /**
     * 根据指定索引位置删除对应节点
     * @param index 要删除的节点的索引值
     */
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null || prev.next == sentinel) {
            throw new IndexOutOfBoundsException();
        }
        prev.next = prev.next.next;
        prev.next.prev = prev;
    }

    /**
     * 根据值删除元素. 如果元素有重复, 则删除第一个
     * @param value 要删除的值
     */
    public void remove(Integer value) {
        Node target = findNodeByValue(value);
        if (target == null) {
            throw new NoSuchElementException();
        }
        target.prev.next = target.next;
        target.next.prev = target.prev;
    }

    /**
     * 删除链表的第一个节点
     */
    public void removeFirst() {
        if (sentinel.next == sentinel) {
            throw new NoSuchElementException();
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
    }

    /**
     * 删除链表的最后一个节点
     */
    public void removeLast() {
        if (sentinel.next == sentinel) {
            throw new NoSuchElementException();
        }
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
    }

    /**
     * 根据索引值查找并返回对应节点对象. 找不到时返回null <br>
     * <b>📌索引-1对应的时哨兵节点, 类内部可以获取</b>
     * @param index 要查找的索引
     * @return 索引值对应的节点或者null
     */
    private Node findNode(int index) {
        Node cur = sentinel;
        int i = -1;
        while (cur.next != sentinel && i < index) {
            cur = cur.next;
            i++;
        }
        return i == index ? cur : null;
    }

    /**
     * 根据元素值查找并返回对应节点. 找不到时返回null, 如果元素有重复, 返回第一个
     * @param value 要查找的值
     * @return 对应的节点或null
     */
    private Node findNodeByValue(int value) {
        Node cur = sentinel.next;
        while (cur != sentinel) {
            if (cur.value == value) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * <h3>节点内部类(双向链表)</h3>
     */
    private static class Node {
        Node next;
        Node prev;
        int value;

        public Node(Node prev, int value, Node next) {
          this.next = next;
          this.prev = prev;
          this.value = value;
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Node cur = sentinel.next;
        while (cur != sentinel) {
            sj.add(String.valueOf(cur.value));
            cur = cur.next;
        }
        return sj.toString();
    }

    /**
     * <h2>遍历方式1 - foreach + {@link Consumer}</h2>
     * 哨兵节点sentinel既是头节点也是尾节点
     * @param consumer 遍历时要对链表中每一项进行的行为
     */
    public void foreach(Consumer<Integer> consumer) {
        Node cur = sentinel.next;
        while (cur != sentinel) {
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
            Node cur = sentinel.next;

            @Override
            public boolean hasNext() {
                return cur != sentinel;
            }

            @Override
            public Integer next() {
                int value = cur.value;
                cur = cur.next;
                return value;
            }
        };
    }

    /**
     * <h2>遍历方式3 - Stream流</h2>
     * @return Stream流对象
     */
    public Stream<Integer> stream() {
        Stream.Builder<Integer> builder = Stream.builder();
        Node cur = sentinel.next;
        while (cur != sentinel) {
            builder.add(cur.value);
            cur = cur.next;
        }
        return builder.build();
    }

    /**
     * <h2>遍历方式4 - 递归遍历</h2>
     * @param consumer 遍历时要对每个元素进行的操作
     */
    public void foreachRecursive(Consumer<Integer> consumer) {
        recursion(sentinel.next, consumer);
    }

    private void recursion(Node cur, Consumer<Integer> consumer) {
        if (cur == sentinel) {
            return;
        }
        // 下面两行顺序调换的话, 就会变成倒序遍历
        consumer.accept(cur.value);
        recursion(cur.next, consumer);
    }

    public void foreachRecursive(Consumer<Integer> before, Consumer<Integer> after) {
        recursion(sentinel.next, before, after);
    }

    private void recursion(Node cur, Consumer<Integer> before, Consumer<Integer> after) {
        if (cur == sentinel) {
            return;
        }
        before.accept(cur.value);
        recursion(cur.next, before, after);
        after.accept(cur.value);
    }
}
