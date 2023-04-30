package wlow01._7_object_oriented;


public class _0_StandardJavabean {
    private String username;
    private String pwd;
    private String mail;
    private char gender;
    private int age;

    //备用的空参构造.
    public _0_StandardJavabean(){}

    //带全部参数的构造
    public _0_StandardJavabean(String username, String pwd, String mail, char gender, int age) {
        this.username = username;
        this.pwd = pwd;
        this.mail = mail;
        this.gender = gender;
        this.age = age;
    }

    //username
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }

    //pwd
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    public String getPwd(){
        return pwd;
    }

    //mail
    public void setMail(String mail){
        this.mail = mail;
    }
    public String getMail(){
        return mail;
    }

    //gender
    public void setGender(char gender){
        if(gender == '男' || gender == '女'){
            this.gender = gender;
        }else{
            System.out.println("您是不是搞错了什么?");
        }
    }
    public char getGender(){
        return gender;
    }

    //age
    public void setAge(int age){
        if(age >= 18 && age <= 100){
            this.age = age;
        }else{
            System.out.println("年龄不符合规定范围!");
        }

    }
    public int getAge(){
        return age;
    }


}
