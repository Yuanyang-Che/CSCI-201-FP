package edu.usc.csci.boneapptheteeth.mvc;

import edu.usc.csci.boneapptheteeth.mvc.dto.Recipe;
import edu.usc.csci.boneapptheteeth.service.SpoonacularApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class SpoonacularController {
    @Autowired
    SimpMessagingTemplate simpleMessagingTemplate;

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public Recipe getRandomRecipeJSON() {
        SpoonacularApiService instance = new SpoonacularApiService();
        this.simpleMessagingTemplate.convertAndSend("topic/interactions", "someone searched a recipe");
        return instance.getRandomRecipe();
    }

}
