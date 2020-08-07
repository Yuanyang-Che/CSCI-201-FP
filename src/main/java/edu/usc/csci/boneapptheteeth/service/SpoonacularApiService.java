package edu.usc.csci.boneapptheteeth.service;

import com.google.gson.JsonObject;
import edu.usc.csci.boneapptheteeth.mvc.dto.Recipe;
import edu.usc.csci.boneapptheteeth.mvc.dto.Recipes;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;

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
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("number","1");
        parameters.put("apiKey","612a8ebcab0b449b8316b61349cc769e");
        ResponseEntity<Recipes> recipes = restTemplate.exchange("https://api.spoonacular.com/recipes/random",
                HttpMethod.GET,
                entity,
                Recipes.class, parameters);
        return recipes.getBody().getRecipes().get(0);
    }

}
