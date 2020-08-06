package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Recipes {
    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    private List<Recipe> recipes = new ArrayList<>();

    @Override
    public String toString(){
        return "recipes{"+
                "recipes=" + recipes.get(0) +
                '}';
    }

}
