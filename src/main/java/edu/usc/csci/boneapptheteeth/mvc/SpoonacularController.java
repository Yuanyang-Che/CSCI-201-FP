package edu.usc.csci.boneapptheteeth.mvc;

import edu.usc.csci.boneapptheteeth.mvc.dto.Recipe;
import edu.usc.csci.boneapptheteeth.service.SpoonacularApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class SpoonacularController {

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public Recipe getRandomRecipeJSON() {
        SpoonacularApiService instance = new SpoonacularApiService();
        return instance.getRandomRecipe();
    }

}
