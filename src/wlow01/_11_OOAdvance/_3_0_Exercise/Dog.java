package wlow01._11_OOAdvance._3_0_Exercise;

public class Dog extends Animal{
    private String type = "狗勾";
    public Dog() {
    }

    public Dog(int age, String color) {
        super(age, color);
        //this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    //method: guard
    public void guard(){
        System.out.println("狗勾在看家.");
    }

    @Override
    public void eat(String sth) {
        System.out.println(getAge() + "岁的" + getColor() + "的狗勾两只前腿死死地包住" + sth + "猛吃");
    }
}
