package wlow01._11_OOAdvance._2_2_Staff;

public class Test {
    public static void main(String[] args) {
        Manager m = new Manager();
        Chef c = new Chef();

        m.work();
        c.work();
        c.setName("张三");
        c.setId("001002003");
        c.setSalary(9999);
        System.out.println(c.getName() + ", " + c.getId() + ", " + c.getSalary());
    }
}
