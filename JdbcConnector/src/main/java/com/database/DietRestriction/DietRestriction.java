package com.database.DietRestriction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DietRestriction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idToken;
    private String diet;
    private String exingred; //excluded ingredient
    private String intolerance;

    public Integer getIdToken() {
        return idToken;
    }

    public void setIdToken(Integer idToken) {
        this.idToken = idToken;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getExingred() {
        return exingred;
    }

    public void setExingred(String exingred) {
        this.exingred = exingred;
    }

    public String getIntolerance() {
        return intolerance;
    }

    public void setIntolerance(String intolerance) {
        this.intolerance = intolerance;
    }
}
