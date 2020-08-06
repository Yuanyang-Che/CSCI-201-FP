package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.hateoas.*;

import javax.print.attribute.standard.Media;
import javax.print.attribute.standard.MediaTray;
import javax.xml.ws.RequestWrapper;

@RestController
@RequestMapping("/recipe")
public class SpoonacularController {

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public Recipe getRandomRecipeJSON() {
        SpoonacularApiResponse instance = new SpoonacularApiResponse();
        Recipe res = instance.getRandomRecipe();
        return res;
    }

//    @RequestMapping(value = "/searchIngredients/{query}")
//    public Recipe getRecipeByIngredientSearch(@PathVariable("query") String query){
//        SpoonacularApiResponse instance = new SpoonacularApiResponse();
//        Recipe res = instance.getRecipeByIngredients(query);
//        return res;
//    }

}
