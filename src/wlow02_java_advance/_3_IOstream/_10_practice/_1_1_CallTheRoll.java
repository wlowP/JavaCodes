package wlow02_java_advance._3_IOstream._10_practice;

import java.io.*;
import java.util.ArrayList;


// 各种随机点名
public class _1_1_CallTheRoll {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("IOPractice/crawledData/data.txt"));
        ArrayList<String> list = new ArrayList<>();
        String name;
        while ((name = br.readLine()) != null){
            list.add(name);
        }

        //callByRate(list, 1000);
        //callByCertainty(list, 10, "老王", 3);
        //callByOnce(list, 2);
        callByWeight(list, 3, false);
    }

    // 30%抽到女生, 70%抽到男生, 第二个参数表示点名的次数.
    public static void callByRate(ArrayList<String> list, int count){
        if (count > list.size()){
            System.err.println("参数错误");
            return;
        }
        int boys = 0;
        // 先把原集合里的乱数据排序一下以便后面根据概率决定抽男生还是女生.
        // 排序成男女有序的集合后就能确定男女的区间了
        list.sort((a, b) -> b.split("-")[1].compareTo(a.split("-")[1]));
        for (String s : list) {
            if (s.contains("男"))
                boys++;
            else break;
        }
        int girls = list.size() - boys, ranIndex;
        int bCount = 0, gCount = 0;
        for (int i = 0; i < count; i++) {
            ranIndex = (int)(Math.random() * 1000 + 1);
            if (ranIndex <= 700) {
                System.out.println(list.get((int) (Math.random() * boys)));
                bCount++;
            } else {
                System.out.println(list.get((int)(Math.random() * girls + boys)));
                gCount++;
            }
        }
        System.out.println("抽到的男生个数: " + bCount);
        System.out.println("抽到的女生个数: " + gCount);
    }

    // 第order次点名一定抽到某人(theChosenOne)
    public static void callByCertainty(ArrayList<String> list, int count, String theChosenOne, int order){
        if (count > list.size() || order > count){
            System.err.println("参数错误");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (i + 1 != order)
                System.out.println(list.get((int)(Math.random() * list.size())).split("-")[0]);
            else
                System.out.println(theChosenOne);
        }
    }

    // 每一轮点名中, 每个人被点到之后就不会再被点到了, 并且如果点完一轮会自动开启下一轮
    public static void callByOnce(ArrayList<String> list, int count) throws IOException{
        // 创建缓存的点名名单
        ArrayList<String> temp = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("IOPractice/crawledData/dataTemp.txt"));
        String info;
        while ((info = br.readLine()) != null){
            temp.add(info);
        }
        int cycle = 0;
        if (temp.size() != 0) {
            System.out.println("=====>>第1轮:");
            cycle++;
        }
        for (int i = 0; i < count; i++) {
            if (temp.size() == 0){
                // 如果发现名单已经读完了, 重新读取再写一个缓存名单.
                BufferedWriter bw = new BufferedWriter(new FileWriter("IOPractice/crawledData/dataTemp.txt"));
                for (String s : list) {
                    bw.write(s);
                    bw.newLine();
                }
                temp = new ArrayList<>(list);
                bw.close();
                System.out.printf("=====>>第%d轮:\n", ++cycle);
            }
            System.out.println(temp.remove((int)(Math.random() * temp.size())));
        }
        // 点完名之后更新缓存名单中的数据.
        BufferedWriter bw1 = new BufferedWriter(new FileWriter("IOPractice/crawledData/dataTemp.txt"));
        for (String s : temp) {
            bw1.write(s);
            bw1.newLine();
        }
        bw1.close();
        br.close();
    }

    // 带权重的随机点名(每个人每次被点到后, 被点到的概率减半. 一开始概率(权重)相等.)
    // 📌📌主要用到几何概型思想
    public static void callByWeight(ArrayList<String> list, int count, boolean reset) throws IOException{
        // reset决定是否要重置权重.
        if (reset)
            initWeight(list);
        ArrayList<Student> roll = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("IOPractice/crawledData/dataWithWeight.txt"));
        String info;
        while ((info = br.readLine()) != null){
            roll.add(new Student(info));
        }
        // 计算出总的权重.
        double totalWeight = 0;
        for (Student student : roll) {
            totalWeight += student.getWeight();
        }
        for (int i = 0; i < count; i++) {
            // 生成随机的(0, 1)内的小数表示抽到的某一个点(几何概型)
            double index = Math.random();
            // 用来跟每个数据的权重区间(几何概型上的范围)比较的值.
            double compare = 0.0;
            for (Student choose : roll) {
                compare += choose.getWeight() / totalWeight;
                if (compare > index){
                    System.out.println("天选之子: " + choose);
                    // 抽到一次后权重减半, 并相应减少总权重值.
                    totalWeight -= choose.getWeight() / 2;
                    choose.setWeight(choose.getWeight() / 2);
                    break;
                }
            }
        }
        // 抽完后更新权重表
        BufferedWriter bw = new BufferedWriter(new FileWriter("IOPractice/crawledData/dataWithWeight.txt"));
        for (Student student : roll) {
            bw.write(student.toString());
            bw.newLine();
        }
        bw.close();
        br.close();
    }
    // 为名单中的每个数据分配初始权重, 都是1.
    private static void initWeight(ArrayList<String> list) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("IOPractice/crawledData/data.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("IOPractice/crawledData/dataWithWeight.txt"));
        String info;
        while ((info = br.readLine()) != null){
            bw.write(info);
            bw.write("--1");
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}

class Student{
    private String name;
    private String gender;
    private int age;
    private double weight;

    public Student() {
    }

    public Student(String name, String gender, int age, double weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }

    // 为data中的数据准备的构造方法
    public Student(String info){
        String[] arr = info.split("--|-");
        this.name = arr[0];
        this.gender = arr[1];
        this.age = Integer.parseInt(arr[2]);
        this.weight = Double.parseDouble(arr[3]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return name +  "-" + gender + "-" + age + "--" + weight;
    }
}