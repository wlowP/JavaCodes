package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PowerSets {
    public static void main(String[] args) {
        List list = new ArrayList();
        Collections.addAll(list, "a", "b", "c");
        // powerSets(list);
        // powerSetsRecursive(list);

        powerSetsBoolArray(list);
    }

    /**
     * 计算并打印集合的幂集. 传入的list应当去重
     * 用到了二进制思想(位图法): n个元素的集合, 幂集就有2^n个, 分别对应了0 - 2^n-1这几个数字的二进制形式.
     * 每个元素只有两种状态: 不在子集里(0表示), 在子集里(1表示), 以此得到幂集.
     * 可以推广到n > 2进制时的情形, 也就是说每个元素有三种状态(n个顾客买水果: 苹果, 香蕉, 梨子, 各只买一种, 共有几种结果?)
     *
     * @param list 去重的list
     */
    public static void powerSets(List list) {
        int j, k; // j复制i的值
        List res = new ArrayList();
        // 乘以2的话用<<位运算会快一些.
        for (int i = 0; i <= (1 << list.size()) - 1; i++) {
            j = i;
            k = 0;
            res.clear();
            while (j != 0) {
                if (j % 2 == 1) {
                    res.add(list.get(k));
                }
                j /= 2;
                k++;
            }
            System.out.println(res);
        }
    }

    // 递归求幂集的'启动方法'
    public static void powerSetsRecursive(List list){
        powerSetsRecursive(list, new ArrayList(), 0);
    }
    /**
     * <a href="https://blog.csdn.net/m0_63433419/article/details/126738477">
     *   CSDN链接
     * </a>
     * 递归求幂集. 采用的是递归二叉树. 每个元素只有加和不加的两种状态
     * 正好对应二叉树的左右分支. 于是, 每个节点的左节点对应将list[pos]选入res的情况,
     * 右节点对应不将list[pos]选入res的情况.
     * 每次递归后pos++, 而递归出口就是当pos == list的长度的时候, 此时打印res即可
     *
     * @param list 要求幂集的原集合
     * @param res list的幂集的其中一个子集
     * @param pos 位置参数
     */
    private static void powerSetsRecursive(List list, List res, int pos) {
        if (list.isEmpty()) return;

        if (pos == list.size()){
            System.out.println(res);
            return;
        }

        // 左递归子树 -> 将list[pos]选入到res中
        res.add(list.get(pos));
        powerSetsRecursive(list, res, pos + 1);

        // 右递归子树 -> 不将list[pos]选入到res中
        res.remove(res.size() - 1); // 📌📌之前加入的元素在这时要删除
        powerSetsRecursive(list, res, pos + 1);
    }

    /**
     * 或者先生成一个布尔值数组, 求出其幂集后再据此打印list
     * 求布尔值数组的幂集不需要像powerSetsRecursive那样在递归过程中将选中的元素删除
     *
     * @param list 需要求幂集的list
     */
    public static void powerSetsBoolArray(List list){
        boolean[] booleans = new boolean[list.size()];
        boolTable(booleans, 0, list);
    }
    public static void boolTable(boolean[] bool, int n, List list){
        if (n < bool.length){
            bool[n] = true;
            boolTable(bool, n + 1, list);
            bool[n] = false;
            boolTable(bool, n + 1, list);
        }else{
            for (int i = 0; i < bool.length; i++) {
                if (bool[i]) System.out.print(list.get(i));
            }
            System.out.println();
        }
    }
}
