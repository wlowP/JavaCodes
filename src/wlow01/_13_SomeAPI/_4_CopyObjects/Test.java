package wlow01._13_SomeAPI._4_CopyObjects;

import com.google.gson.Gson;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr = {11, 22, 33, 44, 55, 66, 77};
        Users u1 = new Users("铃仙", "0001", 1, arr);
        //浅复制. 引用数据复制的是地址值.
//        Users u2 = (Users) u1.clone();
//        u1.getArr()[1] = 999;
//        System.out.println(u1);
//        System.out.println(u2);

        //利用第三方API实现深克隆.
        //第三方库位置: 项目根目录/lib/
        Gson gson = new Gson();
        String s = gson.toJson(u1);
        u1.getArr()[1] = 999;
        Users u3 = gson.fromJson(s, Users.class);
        System.out.println(u1);
        System.out.println(u3);
    }
}
