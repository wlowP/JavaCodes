package wlow03_datastruct_algorithm.datastruct.w1_1_LinkedList;

import java.util.Iterator;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * <h1>单向链表 - 带哨兵节点 SinglyLinkedListSentinel</h1>
 * 链表的头节点不是指向第一个元素, 而是指向一个占位的节点, 称之为<b>「哨兵节点」</b> <br>
 * 这样以后查询/增删的时候就<b>📌📌不用额外考虑链表为空, 增删头节点的特殊情况了</b>
 */
class SinglyLinkedListSentinel implements Iterable<Integer>{
  // 📌📌链表的头节点, 默认指向一个哨兵节点. 哨兵节点的value值无意义
  private final Node head = new Node(0, null);

  public SinglyLinkedListSentinel() {}

  /**
   * 根据索引获取对应元素, 找不到时抛异常 <br>
   * <b>这里不直接复用 {@link #findNode} 是因为findNode允许返回索引为-1的哨兵节点</b>
   * @param index 索引值
   * @return 索引值对应的元素
   */
  public int get(int index) {
      Node cur = head.next;
      int i = 0;
      while (cur != null && i < index) {
          cur = cur.next;
          i++;
      }
      if (i == index && cur != null) {
          return cur.value;
      } else {
          throw new IndexOutOfBoundsException();
      }
  }

  /**
   * 向链表头部新加入一个节点 <br>
   * <b>由于链表头部一定指向哨兵节点, 所以这里操作的都是head.next</b>
   * @param value 要加入的元素
   */
  public void addFirst(int value) {
      head.next = new Node(value, head.next);
  }

  /**
   * 向链表指定索引位置插入一个节点
   * @param value 要插入的节点值
   * @param index 要插入的索引位置
   */
  public void add(int index, int value) {
      // 📌📌因为链表头部存在哨兵节点, 所以不用考虑空链表的情况了
      /*if (index == 0) {
          addFirst(value);
          return;
      }*/

      // 先找到插入位置的前一个节点
      Node prev = findNode(index - 1);
      if (prev == null) {
          throw new IndexOutOfBoundsException();
      }

      prev.next = new Node(value, prev.next);
  }

  /**
   * 向链表尾部位置添加一个节点
   * @param value 添加的节点值
   */
  public void add(int value) {
      Node last = findLastNode();
      // 📌📌因为链表头部总存在一个哨兵节点, 所以寻得的最后一个节点不可能为null
      /*if (last == null) { // 链表为空时
          addFirst(value);
          return;
      }*/
      last.next = new Node(value, null);
  }

  /**
   * 删除第一个节点. <br>
   * 📌<b>得益于Java的垃圾回收机制, 在这里不用显式地删除第一个节点</b>
   */
  public void removeFirst() {
      if (head.next == null) {
          throw new IndexOutOfBoundsException();
      }
      head.next = head.next.next;
  }

  /**
   * 根据指定索引位置删除对应节点 <br>
   * 📌<b>得益于Java的垃圾回收机制, 在这里不用显式地删除目标节点</b>
   * @param index 要删除的节点的索引值
   */
  public void remove(int index) {
      // 📌📌因为链表头部总存在一个哨兵节点, findNode(-1)返回哨兵节点,
      // 所以不需要判断remove(0)的情况了
      /*if (index == 0) {
          removeFirst();
          return;
      }*/
      // 先找到目标节点的前一个节点
      Node prev = findNode(index - 1);
      if (prev == null || prev.next == null) {
          throw new IndexOutOfBoundsException();
      }

      prev.next = prev.next.next;
  }

  /**
   * 根据索引值查找并返回对应节点对象. 找不到时返回null <br>
   * <b>📌索引-1对应的时哨兵节点, 类内部可以获取</b>
   * @param index 要查找的索引
   * @return 索引值对应的节点或者null
   */
  private Node findNode(int index) {
      // 📌📌由于链表头部存在哨兵节点, 所以查找的时候i要设置为-1
      Node cur = head;
      // 因为增删节点的时候, 索引为0的节点之前的节点就是哨兵节点, 其索引为-1
      int i = -1;
      while (cur != null && i < index) {
          cur = cur.next;
          i++;
      }
      return i == index ? cur : null;
  }

  /**
   * 查询并返回尾部节点对象 <br>
   * <b>链表为空时不会返回null, 而是返回哨兵节点</b>
   * @return 尾部节点对象
   */
  private Node findLastNode() {
      // 📌📌因为链表头部总存在一个哨兵节点, 所以寻得的最后一个节点不可能为null
      // if (head == null) {
      //     return null;
      // }
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
      Node cur = head.next;
      while (cur != null) {
          sj.add(String.valueOf(cur.value));
          cur = cur.next;
      }
      return sj.toString();
  }

  /**
   * <h2>遍历方式1 - foreach + {@link Consumer}</h2>
   * <h3>📌📌由于链表头部存在哨兵节点, 所有遍历方式都要从哨兵节点之后的节点开始遍历</h3>
   * @param consumer 遍历时要对链表中每一项进行的行为
   */
  public void foreach(Consumer<Integer> consumer) {
      Node cur = head.next;
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
          Node cur = head.next;
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
      Node cur = head.next;
      while (cur != null) {
          builder.add(cur.value);
          cur = cur.next;
      }
      return builder.build();
  }
}