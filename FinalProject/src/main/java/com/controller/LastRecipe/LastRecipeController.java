package com.controller.LastRecipe;

import com.controller.UserInfo.UserInfoController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/last") // This means URL's start with /last (after Application path)
public class LastRecipeController {

    public static LastRecipeRepository getLastRecipeRepository() {
        return lastRecipeRepository;
    }

    public static void setLastRecipeRepository(LastRecipeRepository lastRecipeRepository) {
        LastRecipeController.lastRecipeRepository = lastRecipeRepository;
    }

    private static LastRecipeRepository lastRecipeRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser(@RequestParam String email, @RequestParam String lastQuery) {

        // Only insert for existing users
        if (!UserInfoController.isUserExist(email)) {
            return "No user: " + email + " exists";
        }

        // See if we already has dietary preference for this user
        Optional<LastRecipe> resultFromDB = lastRecipeRepository.findById(email);
        if (resultFromDB.isPresent()) {
            return "Query already exists for user: " + email;
        }

        LastRecipe lastRecipe = new LastRecipe(email, lastQuery);
        lastRecipeRepository.save(lastRecipe);
        return "Saved New Query";
    }

    @PostMapping(path = "/update") // Map ONLY POST Requests
    public @ResponseBody
    String updateUserInfo(@RequestParam String email, @RequestParam String lastQuery) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Optional<LastRecipe> resultFromDB = lastRecipeRepository.findById(email);
        if (!resultFromDB.isPresent()) {
            return "Query does not exist for user: " + email;
        }

        LastRecipe lastRecipe = resultFromDB.get();
        lastRecipe.setLastQuery(lastQuery);
        lastRecipeRepository.save(lastRecipe);
        return "Update the info for User: " + email;
    }

    @RequestMapping(path = "/search")
    public @ResponseBody
    Iterable<LastRecipe> getUsers(@RequestParam String email) {

        Optional<LastRecipe> lastRecipe = lastRecipeRepository.findById(email);
        return lastRecipe.map(Collections::singleton)
                .orElseGet(Collections::emptySet);
    }


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<LastRecipe> getAllUsers() {

        return lastRecipeRepository.findAll();
    }
}
