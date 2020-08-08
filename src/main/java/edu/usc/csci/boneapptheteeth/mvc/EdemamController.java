package edu.usc.csci.boneapptheteeth.mvc;

import edu.usc.csci.boneapptheteeth.mvc.dto.Recipe;
import edu.usc.csci.boneapptheteeth.service.EdamamApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class EdemamController {

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public Recipe getRandomRecipeJSON() {
        EdamamApiService instance = new EdamamApiService();
        Recipe recipe = instance.getRandomRecipe();
        return recipe;
    }

}