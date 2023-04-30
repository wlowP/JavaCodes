package wlow01._13_SomeAPI._4_CopyObjects;

import java.util.StringJoiner;

public class Users implements Cloneable{
    private String name;
    private String id;
    private int number;
    private int[] arr;

    public Users() {
    }

    public Users(String name, String id, int number, int[] arr) {
        this.name = name;
        this.id = id;
        this.number = number;
        this.arr = arr;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }


    public int[] getArr() {
        return arr;
    }


    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public String toString() {
        return "Users{name = " + name + ", id = " + id + ", number = " + number + ", arr = " + arrToString() + "}";
    }

    private String arrToString(){
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < arr.length; i++) {
            sj.add(arr[i] + "");
        }
        return sj.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
