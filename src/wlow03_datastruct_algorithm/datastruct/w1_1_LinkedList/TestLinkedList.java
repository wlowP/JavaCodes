package wlow03_datastruct_algorithm.datastruct.w1_1_LinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 链表 (线性表的链式描述) <br>
 * 性能: <br>
 *  - 根据索引访问: O(n) <br>
 *  - 增/删: 末尾位置: 已知尾节点 -> O(1), 否则O(n); <br>
 *          起始位置: O(1); 中间位置: O(n)
 */
public class TestLinkedList {
    @Test
    @DisplayName("普通单向链表")
    public void singlyLinkedList() {
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
        System.out.println(list.get(3));

        // list.foreach(System.out::println);

        // for (Integer i : list) {
        //     System.out.println(i);
        // }

        // list.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("带哨兵节点的单向链表")
    public void singlyLinkedListSentinel() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();

        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        list.remove(0);
        list.removeFirst();

        list.add(2, 9);

        System.out.println(list);

        // list.foreach(System.out::println);

        // for (Integer i : list) {
        //     System.out.println(i);
        // }

        // list.stream().forEach(System.out::println);
        System.out.println("get(2): " + list.get(2));
        // System.out.println("get(-1): " + list.get(-1));

    }

    @Test
    @DisplayName("头尾带哨兵节点的双向链表")
    public void doublyLinkedListSentinel() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(0, 9);
        list.add(5, 9);
        list.add(2, 8);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.println(list.get(5));
    }

    @Test
    @DisplayName("带哨兵节点的双向环形链表")
    public void doublyLinkedListSentinelCircular() {
        DoublyLinkedListSentinelCircular list = new DoublyLinkedListSentinelCircular();
        list.addFirst(2);
        list.addFirst(1);
        list.add(3);
        list.add(4);

        System.out.println(list);

        list.removeLast();
        list.removeFirst();

        System.out.println(list);

        list.addFirst(1);
        list.add(4);

        System.out.println(list);
        list.remove(0);
        System.out.println(list);

        list.add(3, 5);
        list.add(3);
        System.out.println(list);

        list.remove(Integer.valueOf(3));
        System.out.println(list);
        list.remove(Integer.valueOf(3));
        System.out.println(list);
        // list.foreach(System.out::println);
        // list.stream().forEach(System.out::println);
        // for (Integer i : list) {
        //     System.out.println(i);
        // }
    }
}
