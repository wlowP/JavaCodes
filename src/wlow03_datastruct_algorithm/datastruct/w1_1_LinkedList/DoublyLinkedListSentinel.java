package wlow03_datastruct_algorithm.datastruct.w1_1_LinkedList;

import java.util.Iterator;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * <h1>双向链表 - 带哨兵节点 DoublyLinkedListSentinel</h1>
 * 节点类Node的成员中多了一个指针prev指向上一个节点 <br>
 * 并且, 链表<b>头部和尾部都存在一个占位的哨兵节点</b>
 */
class DoublyLinkedListSentinel implements Iterable<Integer>{
  /**
   * <h2>链表头部和尾部各存在一个占位的哨兵节点</h2>
   * 由于要互相引用, 因此在构造方法中初始化 <br>
   * 尾部哨兵节点也起到尾结点指针的作用. <b>这也使得双向链表容易操作尾部节点.</b>
   */
  private final Node head;
  private final Node last;

  public DoublyLinkedListSentinel() {
      head = new Node(null, 0, null);
      last = new Node(head, 0, null);
      head.next = last;
  }

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
   * 向链表尾部位置添加一个节点 <br>
   * 由于尾结点已知, 这里就比单向链表要简洁
   * @param value 添加的节点值
   */
  public void add(int value) {
      // Node newNode = new Node(last.prev, value, last);
      // last.prev.next = newNode;
      // last.prev = newNode;
      // 简写为连等式:
      last.prev = (last.prev.next = new Node(last.prev, value, last));
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
      // 双向链表插入新节点涉及到四个更改: 上一个节点的next; 下一个节点的prev; 新节点的prev和next
      // Node newNode = new Node(prev, value, prev.next);
      // prev.next.prev = newNode;
      // prev.next = newNode;
      // 简写为连等式:
      prev.next = (prev.next.prev = new Node(prev, value, prev.next));
  }

  /**
   * 根据指定索引位置删除对应节点 <br>
   * @param index 要删除的节点的索引值
   */
  public void remove(int index) {
      Node prev = findNode(index - 1);
      // 📌📌这里抛异常的条件变为prev.next == last了
      if (prev == null || prev.next == last) {
          throw new IndexOutOfBoundsException();
      }
      // 让前后两个节点直接忽略目标节点就好
      // 若无尾部哨兵节点, 这里需要做更多的判断
      prev.next.next.prev = prev;
      prev.next = prev.next.next;
  }

  // 删除节点时如果直接找对应索引值的节点而不是index - 1的话会多一次判断target == null
  // 因为: 前一个节点为null, 等价于目标节点为null或者目标节点为头部哨兵节点
  /*public void remove1(int index) {
      Node target = findNode(index);
      if (target == null || target == head || target == last) {
          throw new IndexOutOfBoundsException();
      }
      target.prev.next = target.next;
      target.next.prev = target.prev;
  }*/

  /**
   * 删除第一个节点.
   */
  public void removeFirst() {
      if (head.next == last) {
          throw new IndexOutOfBoundsException();
      }
      head.next.next.prev = head;
      head.next = head.next.next;
  }

  /**
   * 删除最后一个节点.
   * <b>能便捷地操作末尾节点, 时双向链表的一大优势</b>
   */
  public void removeLast() {
      if (last.prev == head) {
          throw new IndexOutOfBoundsException();
      }
      last.prev = last.prev.prev;
      last.prev.prev.next = last;
  }

  /**
   * 根据索引值查找并返回对应节点对象. 找不到时返回null <br>
   * <b>📌索引-1对应的时哨兵节点, 类内部可以获取</b>
   * @param index 要查找的索引
   * @return 索引值对应的节点或者null
   */
  private Node findNode(int index) {
      Node cur = head;
      int i = -1;
      while (cur != last && i < index) { // 这里的第一个条件等效于cur.next != null
          cur = cur.next;
          i++;
      }
      return i == index ? cur : null;
  }

  /**
   * <h3>节点内部类. </h3>
   * 因为是双向链表, 所以多了一个指针prev指向上一个节点
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
      Node cur = head.next;
      while (cur != last) {
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
      while (cur != last) {
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
              return cur != last;
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
      while (cur != last) {
          builder.add(cur.value);
          cur = cur.next;
      }
      return builder.build();
  }
}