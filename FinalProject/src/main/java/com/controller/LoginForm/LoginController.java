package com.controller.LoginForm;

import com.controller.UserInfo.UserInfo;
import com.controller.UserInfo.UserInfoController;
import com.controller.UserInfo.UserInfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;


@Controller
public class LoginController {
    //to get login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "login";
    }

    //checking for login credentials
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
        String name = loginForm.getUsername();
        String password = loginForm.getPassword();


        UserInfoRepository userInfoRepository = UserInfoController.getUserInfoRepository();
        Optional<UserInfo> userInfo = userInfoRepository.findById(name);
        if (!userInfo.isPresent()) {
            //not found
            model.addAttribute("invalidCredentials", true);
            return "login";
        }
        else {
            UserInfo user = userInfo.get();
            String correct_pw = user.getPW();
            return correct_pw.equalsIgnoreCase(password) ? "home" : "login";
        }

    }
}
