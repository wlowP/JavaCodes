package wlow01._7_object_oriented._1_Persons;

//测试类.
public class _1_0_Person_0 {

    public static void main(String[] args) {
        _1_0_Person Steve = new _1_0_Person();
        Steve.name = "Steve";
        Steve.age = 20;
        Steve.height = 2.00;
        System.out.println(Steve.name + " " + Steve.age + " " + Steve.height);
        Steve.meal();

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        _1_0_Person rui = new _1_0_Person();
        rui.name = "Reisen·Udongein·Inaba";
        rui.age = 18;
        rui.height = 1.79;
        System.out.println(rui.name + " " + rui.age + " " + rui.height);
        rui.sleep();

    }

}
