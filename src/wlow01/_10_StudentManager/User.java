package wlow01._10_StudentManager;

public class User {
    private String username;
    private String pwd;
    private String id;
    private String phoneNum;

    public User(String username, String pwd, String id, String phoneNum) {
        this.username = username;
        this.pwd = pwd;
        this.id = id;
        this.phoneNum = phoneNum;
    }

    public User() {}

    //username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //pwd
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //phoneNum
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
