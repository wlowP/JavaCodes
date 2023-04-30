package wlow01._11_OOAdvance._2_2_Staff;

public class Manager extends Staff{
    public int adminBonus;

    public Manager() {
    }

    public Manager(String id, String name, int salary, int adminBonus) {
        super(id, name, salary);
        this.adminBonus = adminBonus;
    }

    @Override
    public void work(){
        System.out.println("管理其他人, 都别偷懒");
    }

    /**
     * 获取
     * @return adminPrize
     */
    public int getAdminBonus() {
        return adminBonus;
    }

    /**
     * 设置
     * @param adminBonus
     */
    public void setAdminBonus(int adminBonus) {
        this.adminBonus = adminBonus;
    }

    public String toString() {
        return "Manager{adminPrize = " + adminBonus + "}";
    }
}
