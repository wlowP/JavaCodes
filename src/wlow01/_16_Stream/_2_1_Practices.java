package wlow01._16_Stream;

import java.util.*;
import java.util.stream.Collectors;

public class _2_1_Practices {
    public static void main(String[] args) {
        // 保留数组中的奇数
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> res = list.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
        System.out.println(res);


        // 将查询字符串转为Map
        ArrayList<String> queries = new ArrayList<>();
        Collections.addAll(queries,
                "name=张三&age=18&data=qwer",
                "name=李四&age=19&data=asdf",
                "id=0011&method=POST&params=null"
        );
        List<Map<String, String>> maps = queries.stream()
                .map(query -> Arrays.stream(query.split("&"))
                        .map(entryStr -> entryStr.split("="))
                        .collect(Collectors.toMap(
                                s -> s[0], // 键名
                                s -> s[1]  // 键值
                        )))
                .toList();

        for (Map<String, String> map : maps)
            System.out.println(map);
    }
}
