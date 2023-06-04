package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSets {
    public static void main(String[] args) {
        List list = new ArrayList();
        Collections.addAll(list, 1, 2, 3, 4, "Reisen");
        getPowerSets(list);
    }

    /**
     * 计算并打印集合的幂集. 传入的list应当去重
     * 用到了二进制思想(位图法): n个元素的集合, 幂集就有2^n个, 分别对应了0 - 2^n-1这几个数字的二进制形式.
     * 每个元素只有两种状态: 不在子集里(0表示), 在子集里(1表示), 以此得到幂集.
     *      可以推广到n > 2进制时的情形, 也就是说每个元素有三种状态(n个顾客买水果: 苹果, 香蕉, 梨子, 各只买一种, 共有几种结果?)
     * @param list 去重的list
     */
    public static void getPowerSets(List list){
        int j, k; // j复制i的值
        List res;
        // 乘以2的话用<<位运算会快一些.
        for (int i = 0; i <= (1 << list.size()) - 1; i++) {
            j = i;
            k = 0;
            res = new ArrayList();
            while (j != 0){
                if (j % 2 == 1){
                    res.add(list.get(k));
                }
                j /= 2;
                k++;
            }
            System.out.println(res);
        }
    }
}
