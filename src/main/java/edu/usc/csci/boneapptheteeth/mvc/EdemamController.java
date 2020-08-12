package edu.usc.csci.boneapptheteeth.mvc;

import edu.usc.csci.boneapptheteeth.mvc.dto.Hits;
import edu.usc.csci.boneapptheteeth.mvc.dto.Recipe;
import edu.usc.csci.boneapptheteeth.service.EdamamApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EdemamController {
    @Autowired
    SimpMessagingTemplate simpleMessagingTemplate;

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public Recipe getRecipeBySearchJSON() {
        EdamamApiService instance = new EdamamApiService();
        Recipe recipe = instance.getRandomRecipe();
        return recipe;
    }

    @RequestMapping(value = "/searchRecipe", method = RequestMethod.POST)
    public String getRecipeBySearchJSON(@RequestParam(name = "search", required = true) String query, Model model) {
        EdamamApiService instance = new EdamamApiService();
        Recipe recipe = instance.getRecipeBySearch(query);
        model.addAttribute("recipe", recipe);
        return "recipe";
    }

    @RequestMapping(value = "/searchRecipeTenDiet", method = RequestMethod.POST)
    public String getRecipesBySearchDietaryJSON(@RequestParam(name = "search") String query,
                                                @RequestParam(name = "radioSetOne") String option, Model model) {
        EdamamApiService instance = new EdamamApiService();
        /*String option = (String) model.getAttribute("radioSetOne");*/
        if (option == null) {
            option = "option1";
        }
        if (option.equals("option1")) {
            option = "balanced";
        }
        else if (option.equals("option2")) {
            option = "high-protein";
        }
        else if (option.equals("option3")) {
            option = "low-fat";
        }
        else if (option.equals("option4")) {
            option = "low-carb";
        }
        else {
            option = "balanced";
        }
        Hits hits = instance.getRecipesBySearchDietary(query, option);
        model.addAttribute("hits", hits);
        //System.out.println(hits.getHits().get(0).getRecipe().getLabel());
        this.simpleMessagingTemplate.convertAndSend("/topic/messages", "someone searched a recipe");
        return "recipe";
    }

    @RequestMapping(value = "/searchRecipeTenDietGuest", method = RequestMethod.POST)
    public String getRecipesBySearchDietaryJSONGuest(@RequestParam(name = "search") String query, Model model) {
        EdamamApiService instance = new EdamamApiService();
        String option = "balanced";
        Hits hits = instance.getRecipesBySearchDietary(query, option);
        model.addAttribute("hits", hits);
        return "recipe";
    }
}


