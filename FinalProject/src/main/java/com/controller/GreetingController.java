package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GreetingController extends AbstractController {

    @GetMapping("greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting.jsp";
    }

    @GetMapping("login")
    public String login() {
        return "loginPage.html";
    }

    @GetMapping("index")
    public String query() {
        return "index.jsp";
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("HelloWorldPage");
        model.addObject("msg", "hello world");

        return model;
    }

}
