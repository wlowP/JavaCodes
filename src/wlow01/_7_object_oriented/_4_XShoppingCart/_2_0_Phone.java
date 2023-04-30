package wlow01._7_object_oriented._4_XShoppingCart;

public class _2_0_Phone {
    private String brand;
    private double price;
    private String color;

    public _2_0_Phone() {
    }

    public _2_0_Phone(String brand, double price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    //brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
