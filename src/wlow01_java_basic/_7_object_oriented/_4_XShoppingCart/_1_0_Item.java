package wlow01_java_basic._7_object_oriented._4_XShoppingCart;

import java.util.Scanner;

public class _1_0_Item {
    private String id;
    private String name;
    private String desc;
    private double price;
    private String color;
    Scanner sc = new Scanner(System.in);

    public _1_0_Item(String desc) {
        this.desc = desc;
    }
    public _1_0_Item(){}

    //id
    public String getId() {
        return id;
    }

    public void setId() {
        System.out.println("请输入" + this.desc + "的ID>");
        this.id = sc.next();
    }

    //name
    public String getName() {
        return name;
    }

    public void setName() {
        System.out.println("请输入" + this.desc + "的品牌>");
        this.name = sc.next();
    }

    //price
    public double getPrice() {
        return price;
    }

    public void setPrice() {
        System.out.println("请输入" + this.desc + "的价格>");
        this.price = sc.nextDouble();
    }

    public String getColor() {
        return color;
    }

    public void setColor() {
        System.out.println("请输入" + this.desc + "的颜色>");
        this.color = sc.next();
    }
}