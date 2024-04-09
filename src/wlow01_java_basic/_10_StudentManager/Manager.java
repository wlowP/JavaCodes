package wlow01_java_basic._10_StudentManager;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Manager {
    //模拟学生管理系统. (升级: 加上登录系统)
    public static void main(String[] args) {
        ArrayList<User> uList = new ArrayList<>();
        int chance = 3;
        loop:
        while (true) {
            switch (loginMenu()) {
                case "1" -> {
                    boolean v = login(uList, chance);
                    if (v) {
                        break loop;
                    }
                }
                case "2" -> register(uList);
                case "3" -> chgPwd(uList);
                case "4" -> {
                    System.out.println("退出登录系统...");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项!");
            }
        }

        ArrayList<Student> list = new ArrayList<>();
        //***利用循环标号来在循环嵌套中跳出指定循环.
        loop1:
        while (true) {
            switch (createMenu()) {
                case "1":
                    newStu(list);
                    break;
                case "2":
                    delStu(list);
                    break;
                case "3":
                    changeInfo(list);
                    break;
                case "4":
                    findInfo(list);
                    break;
                case "5":
                    allInfo(list);
                    break;
                case "6":
                    System.out.println("退出系统...");
                    break loop1;
                default:
                    System.out.println("没有这个选项哟!");
                    break;
            }
        }
    }


    //------生成学生系统菜单的方法.
    public static String createMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------===欢迎来到学生管理系统===------------");
        System.out.println("1：添加学生信息");
        System.out.println("2：删除学生信息");
        System.out.println("3：修改学生信息");
        System.out.println("4：查询学生信息");
        System.out.println("5：查看所有学生信息");
        System.out.println("6：退出");
        System.out.println("请输入您的选择:");
        return sc.next();
    }


    //添加学生的方法.
    public static void newStu(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        System.out.println("请输入要添加的学生id(输入000跳过)>");
        String id = sc.next();
        if (id.equals("000")) {
            return;
        }
        //检测id是否重复.
        for (int i = 0; i < list.size(); ) {
            if (id.equals(list.get(i).getId())) {
                System.out.println("此id与已有id重复!请重新输入>");
                id = sc.next();
                i = 0;
            } else {
                i++;
            }
        }
        s.setId(id);
        System.out.println("请输入要添加的学生姓名>");
        s.setName(sc.next());
        System.out.println("请输入要添加的学生年龄>");
        s.setAge(sc.nextInt());
        System.out.println("请输入要添加的学生家庭住址>");
        s.setAddress(sc.next());
        list.add(s);
        System.out.println("添加成功!");
    }


    //修改学生信息的方法.
    public static void changeInfo(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生id:");
        String delId = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (delId.equals(list.get(i).getId())) {
                System.out.println("请输入修改后的姓名>");
                list.get(i).setName(sc.next());
                System.out.println("请输入修改后的年龄>");
                list.get(i).setAge(sc.nextInt());
                System.out.println("请输入修改后的住址>");
                list.get(i).setAddress(sc.next());
                System.out.println("修改完毕.");
                return;
            }
        }
        System.out.println("此id不存在!请重新操作!");
    }


    //删除学生的方法.
    public static void delStu(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生的id>");
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                list.remove(i);
                System.out.println("删除成功!");
                return;
            }
        }
        System.out.println("此id不存在!删除失败!");
    }


    //查询学生信息的方法.
    public static void findInfo(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的学生id>");
        String id = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                list.get(i).showInfo();
                return;
            }
        }
        System.out.println("并没有这个id!请重新操作!");
    }


    //展示所有学生信息的方法.
    public static void allInfo(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("当前无学生信息, 请添加后再查看!");
            return;
        }
        System.out.println("id" + "\t" + "姓名" + "\t" + "年龄" + "\t" + "家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.getId() + "\t" + s.getName() + "\t" + "\t" + s.getAge() + "\t" + "\t" + s.getAddress());
        }
    }

    //判断学生信息是否存在的代码过多重复. 最好定义一个这样的方法(还要能返回索引的).


    //------生成登录菜单的方法.
    public static String loginMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎来到学生管理系统.");
        System.out.println("请选择你的操作:  1->登录  2->注册  3->忘记密码  4->退出");
        return sc.next();
    }


    //----注册用户的方法.
    public static void register(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        User u = new User();
        //设置用户名.
        System.out.println("注册用户, 请输入注册的用户名>");
        String name = sc.nextLine();
        while (!check(list, name)) {
            name = sc.nextLine();
        }
        u.setUsername(name);
        //设置密码以及确认密码.
        System.out.println("用户名设置成功!请设置密码>");
        String pwd = sc.nextLine();
        while (hasSpace(pwd)) {
            System.out.println("密码不能含有空格!请重新输入>");
            pwd = sc.nextLine();
        }
        System.out.println("请重新确认输入的密码>");
        String pwd1 = sc.nextLine();
        while (hasSpace(pwd1)) {
            System.out.println("不能含有空格!请重新输入>");
            pwd1 = sc.nextLine();
        }
        while (true) {
            if (!pwd1.equals(pwd)) {
                System.out.println("两次密码不一致!请再确认一遍!");
                pwd1 = sc.nextLine();
            } else {
                break;
            }
        }
        u.setPwd(pwd);
        System.out.println("密码设置成功!");
        //身份证.
        System.out.println("请输入身份证号码>");
        String id = sc.next();
        while (!checkId(id)) {
            id = sc.next();
        }
        u.setId(id);
        System.out.println("身份证号码设置成功!");
        //手机号码.
        System.out.println("请输入手机号码>");
        String phNum = sc.next();
        while (!checkPhNum(phNum)) {
            phNum = sc.next();
        }
        u.setPhoneNum(phNum);
        System.out.println("手机号设置成功!");
        list.add(u);
        System.out.println("注册成功!");
    }


    //排查不合理用户名的方法.
    public static boolean check(ArrayList<User> list, String name) {
        //检测用户名长度, 要求为3~15.
        int len = name.length();
        if (len < 3 || len > 15) {
            System.out.println("用户名长度不符合范围!应为3~15位之间.");
            return false;
        }
        //检测唯一性.
        if (contains(list, name) > -1) {
            System.out.println("此用户名已存在!请换一个用户名>");
            return false;
        }
        //用户名只能是字母加数字的组合, 但是不能是纯数字, 不得有空格.
        boolean hasCharacter = false, hasNum = false, hasSpace = false;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
                hasCharacter = true;
            }
            if (c >= '0' && c <= '9') {
                hasNum = true;
            }
            if (c == ' ') {
                hasSpace = true;
            }
        }
        if (hasCharacter && hasNum && !hasSpace) {
            return true;
        } else {
            System.out.println("用户名应为字母加数字的组合，但是不能是纯数字, 也不能含有空格!");
            return false;
        }
        /*/*****更妙的判断----取补集:
        if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))){
            return false;
        }*/
    }


    //判断用户名是否存在的方法.
    public static int contains(ArrayList<User> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).getUsername())) {
                return i;
            }
        }
        return -1;
    }


    //判断字符串是否含有空格的方法.
    public static boolean hasSpace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                return true;
            }
        }
        return false;
    }


    //检查身份证号码是否正确的方法.
    public static boolean checkId(String id) {
        if (id.length() != 18) {
            System.out.println("身份证号码应为18位!请重新输入>");
            return false;
        }
        if (id.charAt(0) == '0') {
            System.out.println("身份证号码不能以0开头!重新输入>");
            return false;
        }
        for (int i = 0; i < 18; i++) {
            char c = id.charAt(i);
            if (i == 17) {
                if ((c < '0' || c > '9') && c != 'x' && c != 'X') {
                    System.out.println("身份证最后一位仅能为数字或者大写或小写的字母x!重新输入>");
                    return false;
                }
            }
            if (c < '0' || c > '9') {
                System.out.println("身份证前17位必须全是数字!重新输入>");
                return false;
            }
        }
        return true;
    }


    //检查手机号码是否符合要求的方法.
    public static boolean checkPhNum(String num) {
        if (num.length() != 11) {
            System.out.println("手机号码必须为11位!重新输入>");
            return false;
        }
        if (num.charAt(0) == '0') {
            System.out.println("手机号码不能以0开头!重新输入>");
            return false;
        }
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) < '0' || num.charAt(i) > '9') {
                System.out.println("手机号码当然全都是数字啊!重新输入>");
                return false;
            }
        }
        return true;
    }


    //用户登录的方法.
    public static boolean login(ArrayList<User> list, int chance) {
        Scanner sc = new Scanner(System.in);
        System.out.println("用户登录, 请输入用户名(不含空格)>");
        String name = sc.next();
        System.out.println("请输入登录密码(不含空格)>");
        String pwd = sc.next();
        String veriCode = null;
        int index = contains(list, name);
        if (index > -1) {
            veriCode = createCode();
        }
        if (index == -1) {
            System.out.println("用户名未注册，请先注册!");
            return false;
        }
        System.out.println("发送验证码到用户手机...");
        System.out.println("[短信] 验证码为: " + veriCode + " , 如不是您本人操作请忽略, 谨防上当受骗.");
        System.out.println("请输入验证码>");
        String veriCode1 = sc.next();
        while (true) {
            if (veriCode1.equals(veriCode)) {
                break;
            } else {
                System.out.println("验证码不正确!重新输入>");
                veriCode1 = sc.next();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (pwd.equals(list.get(index).getPwd())) {
                System.out.println("登录成功!进入学生管理系统...");
                break;
            } else {
                chance--;
                if (chance == 0) {
                    System.out.println("失误次数过多, 请重新操作.");
                    return false;
                } else {
                    System.out.println("密码错误!请重新输入密码, 你还有" + chance + "次机会.");
                    pwd = sc.next();
                }
            }
        }
        return true;
    }


    //生成验证码的方法.
    public static String createCode() {
        Random r = new Random();
        char[] code = new char[5];
        //***先创建包含所有大小写字母的字符数组.
        char[] letter = new char[52];
        for (int i = 0; i < letter.length; i++) {
            if (i <= 25) {
                letter[i] = (char) (i + 65);
            } else {
                letter[i] = (char) (i + 71);
            }
        }
        for (int i = 0; i < code.length; i++) {
            int ranIndex = r.nextInt(letter.length);
            code[i] = letter[ranIndex];
        }
        //将其中一位替换为数字.
        code[r.nextInt(code.length)] = (char) (r.nextInt('0', '9'));
        return new String(code);
    }


    //忘记密码修改密码的方法.
    public static void chgPwd(ArrayList<User> list) {
        System.out.println("忘记密码, 请根据提示修改密码.");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名>");
        String name = sc.nextLine();
        while (hasSpace(name)) {
            System.out.println("不能含有空格!重新输入>");
            name = sc.nextLine();
        }
        int index = contains(list, name);
        if (index == -1) {
            System.out.println("该用户名未注册!请先注册呀!");
            return;
        }
        System.out.println("请输入该用户的身份证号码>");
        String id = sc.next();
        System.out.println("然后输入该用户的手机号码>");
        String phNum = sc.next();
        if (!(id.equalsIgnoreCase(list.get(index).getId()) && phNum.equals(list.get(index).getPhoneNum()))) {
            System.out.println("账号信息不匹配, 修改失败!请重新操作.");
            return;
        }
        String newPwd;
        String newPwd1;
        while (true) {
            System.out.println("请输入密码进行修改>");
            newPwd = sc.next();
            System.out.println("请再确认一遍密码, 并且不要再忘了>");
            newPwd1 = sc.next();
            if (newPwd.equals(newPwd1)){
                break;
            }else{
                System.out.println("两次密码不一致!请重新输入.");
            }
        }
        list.get(index).setPwd(newPwd);
        System.out.println("密码修改成功!请凭新密码登录.");
    }
}

