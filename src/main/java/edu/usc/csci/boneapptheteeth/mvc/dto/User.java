package edu.usc.csci.boneapptheteeth.mvc.dto;

public abstract class User {
    protected String IPAddress;
    protected String port;

    public User() {
        this.IPAddress = null;
        this.port = null;
    }

    public User(String port, String IPAddress) {
        this.IPAddress = IPAddress;
        this.port = port;
    }
}
