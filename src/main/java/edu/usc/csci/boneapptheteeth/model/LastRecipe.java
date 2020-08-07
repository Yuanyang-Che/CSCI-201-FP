package edu.usc.csci.boneapptheteeth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class LastRecipe {
    @Id @Column(columnDefinition = "VARCHAR(45)", nullable = false, unique = true)
    private String email;
    @Column(columnDefinition = "VARCHAR(45)")
    private String lastQuery;

    public LastRecipe() {
    }

    public LastRecipe(String email, String lastQuery) {
        this.email = email;
        this.lastQuery = lastQuery;
    }

    public String getEmail() {
        return email;
    }


    public String getLastQuery() {
        return lastQuery;
    }

    public void setLastQuery(String lastQuery) {
        this.lastQuery = lastQuery;
    }
}
