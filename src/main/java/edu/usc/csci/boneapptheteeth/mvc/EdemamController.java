package edu.usc.csci.boneapptheteeth.mvc;

import edu.usc.csci.boneapptheteeth.mvc.dto.Recipe;
import edu.usc.csci.boneapptheteeth.service.EdamamApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class EdemamController {
    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public Recipe getRecipeBySearchJSON() {
        EdamamApiService instance = new EdamamApiService();
        Recipe recipe = instance.getRandomRecipe();
        return recipe;
    }
    @GetMapping("/search/{query}")
    public Recipe getRecipeBySearchJSON(@PathVariable("query") String query) {
        EdamamApiService instance = new EdamamApiService();
        Recipe recipe = instance.getRecipeBySearch(query);
        return recipe;
    }
}