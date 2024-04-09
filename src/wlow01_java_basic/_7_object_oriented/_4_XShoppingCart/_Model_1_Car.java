package wlow01_java_basic._7_object_oriented._4_XShoppingCart;

public class _Model_1_Car {
    private String brand;//品牌
    private int price;//价格
    private String color;//颜色


    public _Model_1_Car() {
    }

    public _Model_1_Car(String brand, int price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
