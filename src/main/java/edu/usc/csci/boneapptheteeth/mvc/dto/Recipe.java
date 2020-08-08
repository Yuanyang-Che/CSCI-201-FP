package edu.usc.csci.boneapptheteeth.mvc.dto;

public class Recipe {
    private String uri;
    private String label;
    private String image;
    private String url;
    private String yield;
    private String ingredientLines;
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServings() {
        return yield;
    }

    public void setServings(String servings) {
        this.yield = servings;
    }

    public String getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(String ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

}
