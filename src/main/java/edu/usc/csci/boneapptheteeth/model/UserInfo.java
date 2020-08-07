package edu.usc.csci.boneapptheteeth.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class UserInfo {
    /*@GeneratedValue(strategy = GenerationType.AUTO) //auto generate one
    private Integer idToken;*/

    @Id //mark that email is the "ID" of user, this should be the key for lookups
    private String email;
    private String userName;
    private String password;

    public UserInfo() {
        super();
    }

    public UserInfo(String email, String userName, String pw) {
        this.email = email;
        this.userName = userName;
        this.password = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pw) {
        this.password = pw;
    }
}
