package edu.usc.csci.boneapptheteeth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DietRestriction {
    @Id @Column(columnDefinition = "VARCHAR(45) ", nullable = false,unique = true)
    private String email;
    @Column(columnDefinition = "VARCHAR(100)")
    private String diet;
    @Column(columnDefinition = "VARCHAR(100)")
    private String exingred; //excluded ingredient
    @Column(columnDefinition = "VARCHAR(100)")
    private String intolerance;

    public DietRestriction() {
    }

    public DietRestriction(String email, String diet, String exingred, String intolerance) {
        this.email = email;
        this.diet = diet;
        this.exingred = exingred;
        this.intolerance = intolerance;
    }

    public String getEmail() {
        return email;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getExIngred() {
        return exingred;
    }

    public void setExIngred(String exingred) {
        this.exingred = exingred;
    }

    public String getIntolerance() {
        return intolerance;
    }

    public void setIntolerance(String intolerance) {
        this.intolerance = intolerance;
    }
}
