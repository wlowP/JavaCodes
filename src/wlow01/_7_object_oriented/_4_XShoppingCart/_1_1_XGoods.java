package wlow01._7_object_oriented._4_XShoppingCart;

public class _1_1_XGoods {
    public static void main(String[] args) {
        _1_0_Item c1 = new _1_0_Item("第一辆车");
        _1_0_Item c2 = new _1_0_Item("第二辆车");
        _1_0_Item c3 = new _1_0_Item("第三辆车");



        //****牢记对象什么的都是引用数据类型!!!!!
        //****这样子创建包含多个对象的数组:
        _1_0_Item[] arr = new _1_0_Item[3];
        arr[0] = c1;
        arr[1] = c2;
        arr[2] = c3;

        for (int i = 0; i < arr.length; i++) {
            _1_0_Item item = arr[i];
            item.setId();
            item.setName();
            item.setPrice();
            item.setColor();
        }

        //****利用对象引用数据类型的特性遍历数组, 展示对象的属性:
        for (int i = 0; i < arr.length; i++) {
            _1_0_Item item = arr[i];
            System.out.println("商品ID:" + item.getId() + " , 商品名称:" + item.getName() + " , 商品价格:" + item.getPrice());
        }

    }
}
