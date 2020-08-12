package edu.usc.csci.boneapptheteeth.service;

import edu.usc.csci.boneapptheteeth.mvc.dto.Hits;
import edu.usc.csci.boneapptheteeth.mvc.dto.Recipe;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EdamamApiService {
    private String status;
    private Integer code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    //returns
    public Recipe getRandomRecipe() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();
        Hits hits = restTemplate.getForObject("https://api.edamam.com/search?q={query}&app_id=c311f2e8&app_key=f12e909221053a3cb5850cc10379f0da",
                Hits.class, "chicken");

        return hits.getHits().get(0).getRecipe();
    }

    public Recipe getRecipeBySearch(String query) {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();
        String url = "https://api.edamam.com/search?q=" + query
                + "&app_id=c311f2e8&app_key=f12e909221053a3cb5850cc10379f0da";
        Hits hits = restTemplate.getForObject(url,
                Hits.class);
        return hits.getHits().get(0).getRecipe();
    }

    public Hits getTenRecipesBySearch(String query) {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();
        String url = "https://api.edamam.com/search?q=" + query
                + "&to=10&app_id=c311f2e8&app_key=f12e909221053a3cb5850cc10379f0da";
        Hits hits = restTemplate.getForObject(url,
                Hits.class);
        return hits;
    }

    public Hits getRecipesBySearchDietary(String query, String diet) {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();
        String url = "https://api.edamam.com/search?q=" + query
                + "&diet=" + diet + "&to=10&app_id=c311f2e8&app_key=f12e909221053a3cb5850cc10379f0da";
        Hits hits = restTemplate.getForObject(url, Hits.class);
        return hits;
    }
}
