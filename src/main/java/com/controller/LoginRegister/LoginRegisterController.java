package com.controller.LoginRegister;

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
public class LoginRegisterController {
    //to get login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "login";
    }

    //checking for login credentials
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();

        UserInfoRepository userInfoRepository = UserInfoController.getUserInfoRepository();
        Optional<UserInfo> userInfo = userInfoRepository.findById(email);
        if (!userInfo.isPresent()) {
            //not found
            model.addAttribute("invalidCredentials", true);
            return "login";
        }
        else {
            UserInfo user = userInfo.get();
            String correct_pw = user.getPassword();
            return correct_pw.equalsIgnoreCase(password) ? "home" : "login";
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterForm() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("registerForm") UserInfo createdUser, Model model) {
        String email = createdUser.getEmail();
        String userName = createdUser.getUserName();
        String password = createdUser.getPassword();

        UserInfoRepository userInfoRepository = UserInfoController.getUserInfoRepository();
        Optional<UserInfo> userInfo = userInfoRepository.findById(email);
        if (userInfo.isPresent()) {
            //already exists
            model.addAttribute("invalidCredentials", true);
            return "register";
        }
        else {
            UserInfo user = new UserInfo(email, userName, password);
            userInfoRepository.save(user);
            return "home";
        }
    }

    @RequestMapping(value = "/guest", method = RequestMethod.GET)
    public String getGuest() {
        return "homeGuest";
    }
}
