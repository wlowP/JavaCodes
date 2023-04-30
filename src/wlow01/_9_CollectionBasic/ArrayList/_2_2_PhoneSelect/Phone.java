package wlow01._9_CollectionBasic.ArrayList._2_2_PhoneSelect;

public class Phone {
    private String brand;
    private double price;

    public Phone() {
    }

    public Phone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    //brand.
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

    //show info.
    public void sout(){
        System.out.println("品牌:" + this.getBrand() + ", 价格:" + this.getPrice());
    }
}
