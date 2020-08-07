package edu.usc.csci.boneapptheteeth.mvc;

import edu.usc.csci.boneapptheteeth.model.DietRestriction;
import edu.usc.csci.boneapptheteeth.model.DietRestrictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/diet") // This means URL's start with /diet(after Application path)
public class DietRestrictionController {
    @Autowired
    public DietRestrictionRepository dietRestrictionRepository;
    @Autowired
    private UserInfoController userInfoController;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addDietRestriction(@RequestParam String email, @RequestParam String diet,
                              @RequestParam String exIngred, @RequestParam String intolerance) {

        // Only insert for existing users
        if (!userInfoController.isUserExist(email)) {
            return "No user: " + email + " exists";
        }

        // See if we already has dietary preference for this user
        Optional<DietRestriction> resultFromDB = dietRestrictionRepository.findById(email);
        if (resultFromDB.isPresent()) {
            return "Diet Restriction Data for user: " + email + " already exists";
        }

        DietRestriction dietRestriction = new DietRestriction(email, diet, exIngred, intolerance);
        return "Saved New Dietary Restriction";
    }

    @PostMapping(path = "/update") // Map ONLY POST Requests
    public @ResponseBody
    String updateDietRestriction(@RequestParam String email, @RequestParam String diet,
                                 @RequestParam String exIngred, @RequestParam String intolerance) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        //check if we have this record already
        Optional<DietRestriction> resultFromDB = dietRestrictionRepository.findById(email);
        if (!resultFromDB.isPresent()) {
            return "No record found, Cannot update info";
        }

        DietRestriction newDiet = resultFromDB.get();

        newDiet.setDiet(diet);
        newDiet.setExIngred(exIngred);
        newDiet.setIntolerance(intolerance);
        dietRestrictionRepository.save(newDiet);
        return "Update the dietary restriction for user " + email;
    }

    @RequestMapping(path = "/search")
    public @ResponseBody
    Iterable<DietRestriction> getDiet(@RequestParam String email) {
        // This returns a JSON or XML with the users

        Optional<DietRestriction> o = dietRestrictionRepository.findById(email);
        return o.map(Collections::singleton)
                .orElseGet(Collections::emptySet);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<DietRestriction> getAllDietRestrictions() {
        // This returns a JSON or XML with the users
        return dietRestrictionRepository.findAll();
    }
}
