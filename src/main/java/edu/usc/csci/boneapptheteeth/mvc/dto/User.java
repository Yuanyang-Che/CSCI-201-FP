package edu.usc.csci.boneapptheteeth.mvc.dto;

public abstract class User {
    protected String IPAddress;
    protected String port;
    protected String name;
    protected String email;
    protected String password; 
    
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password; 
    }
    public void changePassword(String naem) {
        this.password = password;
    }
    
    public void changeName(String name) {
        this.name = name;
    }
    
    public void changeEmail(String email) {
        this.email = email;
    }
}
