package wlow01_java_basic._15_CollectionAndMap;

import java.util.ArrayList;

public class _1_3_GenericsPractice {
    public static void main(String[] args) {
        Persian p = new Persian("小波", 2);
        LiHua l = new LiHua("小狸", 3);
        Teddy t = new Teddy("阿迪", 2);
        Huskie h = new Huskie("酷奇", 2);

        ArrayList<Creature> list = new ArrayList<>();
        list.add(p);
        list.add(l);
        list.add(t);
        list.add(h);

        ArrayList<Huskie> listH = new ArrayList<>();
        listH.add(h);
        keepPet(listH);
    }

    public static void keepPet(ArrayList<? extends Creature> list) {
        for (Creature creature : list) {
            creature.eat();
        }
    }
}

abstract class Creature {
    String name;
    int age;

    public Creature(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void eat();
}

abstract class Cat extends Creature {
    public Cat(String name, int age) {
        super(name, age);
    }
}

abstract class Dog extends Creature {
    public Dog(String name, int age) {
        super(name, age);
    }
}

class Persian extends Cat {
    public Persian(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(age + "岁的波斯猫" + name + "正在吃小饼干");
    }
}

class LiHua extends Cat {
    public LiHua(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(age + "岁的狸花猫" + name + "正在吃鱼罐头");
    }
}

class Teddy extends Dog {
    public Teddy(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(age + "岁的泰迪" + name + "正在吃骨头");
    }
}

class Huskie extends Dog {
    public Huskie(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(age + "岁的哈士奇" + name + "正在拆家");
    }
}
