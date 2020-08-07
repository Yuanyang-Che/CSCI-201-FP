package com.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpoonacularApiResponse {

    private String status;
    private Integer code;

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Integer getCode(){
        return code;
    }

    public void setCode(Integer code){
        this.code = code;
    }

    public Recipe getRandomRecipe(){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();
        Recipes recipes = restTemplate.getForObject(
                "https://api.spoonacular.com/recipes/random?number=1&apiKey=612a8ebcab0b449b8316b61349cc769e",
                Recipes.class);
        return recipes.getRecipes().get(0);
    }

//    public Recipe getRecipeByIngredients(String query){
//        RestTemplateBuilder builder = new RestTemplateBuilder();
//        RestTemplate restTemplate = builder.build();
//        JsonArray result = restTemplate.getForObject(
//                "https://api.spoonacular.com/recipes/findByIngredients?ingredients={query}&number=10&apiKey=612a8ebcab0b449b8316b61349cc769e",
//                JsonArray.class,query);
//        JsonObject searches = (JsonObject) result.get(0);
//        System.out.println(searches);
//        JsonElement recipeIdJSON = searches.get("id");
//        int recipeId = Integer.parseInt(String.valueOf(recipeIdJSON));
//
//        Recipe recipeById = restTemplate.getForObject(
//                "https://api.spoonacular.com/recipes/{id}/information?apiKey=612a8ebcab0b449b8316b61349cc769e",
//                Recipe.class,recipeId);
//        return recipeById;
//    }

}
