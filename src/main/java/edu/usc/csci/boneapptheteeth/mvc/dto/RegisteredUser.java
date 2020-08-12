package edu.usc.csci.boneapptheteeth.mvc.dto;

public class RegisteredUser extends User {
    private String name;
    private String email;
    private String password;

    private String access = "registered";

    public RegisteredUser(String port, String IPAddress ,String name, String email, String password) {
        super(port, IPAddress);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeName(String name) { this.name = name; }

    public void changeEmail(String email) {
        this.email = email;
    }
}
