package wlow01_java_basic._11_OOAdvance._$_Experiments._1_Bank;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Account ac1 = new Account("reisen", "0001", 10000);
        Account ac2 = new Account("reimu", "0002", 10);
        Account ac3 = new Account("remilia", "0003", 999999999);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要操作的账号名: (密码免了)");
        String ac = sc.next();
        Account ac0;
        if (ac.equals(ac1.getAccount())){
            ac0 = ac1;
        } else if (ac.equals(ac2.getAccount())) {
            ac0 = ac2;
        } else if (ac.equals(ac3.getAccount())) {
            ac0 = ac3;
        }else {
            System.out.println("该账号不存在! ");
            return;
        }
        while (true){
            menu();
            switch (sc.nextInt()){
                case 1 -> {
                    System.out.println("请输入要存款的金额: ");
                    ac0.deposit(sc.nextDouble());
                    System.out.println("存款成功!");
                    ac0.check();
                }
                case 2 -> {
                    System.out.println("请输入要取款的金额: ");
                    double v = sc.nextDouble();
                    if (v > ac0.getBalance()){
                        System.out.println("余额不足!请重新输入.");
                        break;
                    }
                    ac0.withdraw(v);
                    System.out.println("取款成功!");
                    ac0.check();
                }
                case 3 ->{
                    ac0.check();
                }
                case 4 -> System.exit(0);
                default -> System.out.println("妹有这个选项!");
            }
        }
    }

    public static void menu(){
        System.out.println("===银行管理系统===");
        System.out.println("1 - 存款" + "\n" + "2 - 取款" + "\n" + "3 - 查询用户信息" + "\n" + "4 - 退出" + "\n" + "请输入选择: ");
    }
}

class Account {
    private String username;
    private String account;
    private double balance;
    private final double rateInterest = 0.005;

    public Account() {
    }

    public Account(String username, String account, double balance) {
        this.username = username;
        this.account = account;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //===================

    public void sumInterest(){
        balance += balance * rateInterest;
    }

    public void deposit(double num){
        balance += num;
        sumInterest();
        check();
    }

    public void withdraw(double num){
        balance -= num;
        sumInterest();
        check();
    }

    public void check(){
        System.out.println("查询账户信息:");
        System.out.println("用户名: " + "\t" + username + "\n" + "账号: " + "\t" + account + "\n" + "余额: " + "\t" + balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", balance=" + balance +
                '}';
    }
}