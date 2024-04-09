package wlow01_java_basic._7_object_oriented._3_XTextFTG;

import java.util.Random;

public class _1_0_XCharacter {
    private int health = 1000;
    private String name;
    //private boolean ko = false;
    private String appearance;


    //备用的空参构造.
    public _1_0_XCharacter(){}

    public _1_0_XCharacter(String name , int health ){
        Random r = new Random();
        this.name = name;
        this.health = health;
        String[] appearances = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平", "相貌简陋", "惨不忍睹"};
        this.appearance = appearances[r.nextInt(0, appearances.length - 1)];
    }

    //health.
    public int getHealth(){
        return health;
    }

    //name.
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    //appearance
    public String getAppearance(){
        return appearance;
    }

    //attack. ******************创建的对象也是引用数据类型!!!
    public void attack(_1_0_XCharacter character){
        //设置随机伤害:
        Random r = new Random();
        int damage = r.nextInt(100,151);

        //人物血量DoDelta
        character.health -= damage;

        //**防止血量变负数.用if也可以.
        character.health = character.health < 0 ? 0 : character.health;
        System.out.println(this.name + "抡起拳头打了" + character.name + "一下, 造成了" + damage + "点伤害, " + character.name + "还剩" + character.health + "点血.");
    }

    public void attack2(_1_0_XCharacter character){
        //生动的攻击&受伤描述:
        String[] attack_desc={
                "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
                "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
                "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
                "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
                "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
                "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
        };
        String[] injure_desc={
                "结果给%s造成一处瘀伤",
                "结果一击命中，%s痛得弯下腰",
                "结果%s痛苦地闷哼了一声，显然受了点内伤",
                "结果%s摇摇晃晃，一跤摔倒在地",
                "结果%s脸色一下变得惨白，连退了好几步",
                "结果%s一声惨叫，像滩软泥般塌了下去"
        };

        //设置随机伤害:
        Random r = new Random();
        int damage = r.nextInt(100,151);

        //人物血量DoDelta
        character.health -= damage;

        //**防止血量变负数.用if也可以.
        character.health = character.health < 0 ? 0 : character.health;

        System.out.println();
        System.out.printf(attack_desc[r.nextInt(attack_desc.length)] + injure_desc[r.nextInt(injure_desc.length)] + "," + character.name + "还剩" + character.health + "点血." , this.name , character.name , character.name);
    }

    //be ko.
/*    public void setKO(boolean ko){
        this.ko = ko;
    }
    public boolean ifKO(){
        return ko;
    }*/





}
