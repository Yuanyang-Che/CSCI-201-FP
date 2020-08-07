package com.controller;

import com.controller.Recipe;
import com.controller.SpoonacularApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class SpoonacularController {

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public Recipe getRandomRecipeJSON() {
        SpoonacularApiResponse instance = new SpoonacularApiResponse();
        return instance.getRandomRecipe();
    }

}
