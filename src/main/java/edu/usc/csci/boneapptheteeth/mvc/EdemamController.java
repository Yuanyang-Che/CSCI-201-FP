package edu.usc.csci.boneapptheteeth.mvc;

import edu.usc.csci.boneapptheteeth.mvc.dto.Recipe;
import edu.usc.csci.boneapptheteeth.service.EdamamApiService;
import org.springframework.ui.Model;
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
    @GetMapping("/searchData")
    public Recipe getRecipeBySearchJSON(@RequestParam(name = "search", required = true) String query,  Model model) {
        EdamamApiService instance = new EdamamApiService();
        Recipe recipe = instance.getRecipeBySearch(query);
        model.addAttribute("recipe", recipe);
        return recipe;
    }
}