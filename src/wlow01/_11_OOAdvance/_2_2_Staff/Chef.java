package wlow01._11_OOAdvance._2_2_Staff;

public class Chef extends Staff{

    public Chef() {
    }

    public Chef(String id, String name, int salary) {
        super(id, name, salary);
    }

    @Override
    public void work(){
        System.out.println("工作, 炒菜");
    }

}
