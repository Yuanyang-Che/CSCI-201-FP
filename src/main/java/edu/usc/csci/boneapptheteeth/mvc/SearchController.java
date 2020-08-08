package edu.usc.csci.boneapptheteeth.mvc;

import edu.usc.csci.boneapptheteeth.model.UserInfo;
import edu.usc.csci.boneapptheteeth.mvc.dto.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;


@Controller
public class SearchController {

    //to get login page
    @RequestMapping(value = "/searchRecipe", method = RequestMethod.GET)
    public String getLoginForm() {
        return "login";
    }

    //checking for login credentials
    @RequestMapping(value = "/searchRecipe", method = RequestMethod.POST)
    public String login(@ModelAttribute("searchResults") LoginForm loginForm, Model model) {
        return null;
    }

}
