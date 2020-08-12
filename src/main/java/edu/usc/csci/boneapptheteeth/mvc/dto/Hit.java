package edu.usc.csci.boneapptheteeth.mvc.dto;

import java.io.Serializable;

public class Hit implements Serializable {
    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    private Recipe recipe;
}
