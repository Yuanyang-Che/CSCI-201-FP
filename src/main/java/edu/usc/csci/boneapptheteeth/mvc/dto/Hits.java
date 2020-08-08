package edu.usc.csci.boneapptheteeth.mvc.dto;

import java.util.ArrayList;
import java.util.List;

public class Hits {
    private List<Hit> hits = new ArrayList<>();

    public List<Hit> getHits() {
        return hits;
    }

    public void setRecipes(List<Hit> hits) {
        this.hits = hits;
    }

    @Override
    public String toString(){
        return "recipes{"+
                "recipes=" + hits +
                '}';
    }
}
