package edu.usc.csci.boneapptheteeth.mvc;

import edu.usc.csci.boneapptheteeth.mvc.dto.Recipe;
import edu.usc.csci.boneapptheteeth.service.EdamamApiService;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.PolicyParser;

import java.security.Principal;

@RestController
public class EdemamController {
    @Autowired
    SimpMessagingTemplate simpleMessagingTemplate;

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public Recipe getRecipeBySearchJSON() {
        EdamamApiService instance = new EdamamApiService();
        Recipe recipe = instance.getRandomRecipe();
        return recipe;
    }
    @RequestMapping(value = "/searchRecipe", method = RequestMethod.GET)
    public Recipe getRecipeBySearchJSON(@PathVariable("query") String query, Principal user) {
        EdamamApiService instance = new EdamamApiService();
        Recipe recipe = instance.getRecipeBySearch(query);
        this.simpleMessagingTemplate.convertAndSend("/topic/messages", "someone searched a recipe");
        return recipe;
    }
}