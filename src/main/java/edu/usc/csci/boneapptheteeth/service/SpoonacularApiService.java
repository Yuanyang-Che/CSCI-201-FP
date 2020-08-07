package edu.usc.csci.boneapptheteeth.service;

import edu.usc.csci.boneapptheteeth.mvc.dto.Recipe;
import edu.usc.csci.boneapptheteeth.mvc.dto.Recipes;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpoonacularApiService {

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

}
