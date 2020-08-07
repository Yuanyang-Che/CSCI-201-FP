package edu.usc.csci.boneapptheteeth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
public class UserInfo {
    /*@GeneratedValue(strategy = GenerationType.AUTO) //auto generate one
    private Integer idToken;*/

    @Id @Column(columnDefinition = "VARCHAR(45)",unique = true, nullable = false)
    private String email;
    @Column(columnDefinition = "VARCHAR(45)",unique = true, nullable = false)
    private String userName;
    @Column(columnDefinition = "VARCHAR(45)",nullable = false)
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
