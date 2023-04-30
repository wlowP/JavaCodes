package wlow01._9_CollectionBasic.ArrayList._2_1_FindUser;

public class User {
    private String id;
    private String username;
    private String pwd;

    public User() {
    }

    public User(String id, String username, String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }


    //id
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    //name
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

    public String toString() {
        return "User{id = " + id + ", username = " + username + ", pwd = " + pwd + "}";
    }
}
