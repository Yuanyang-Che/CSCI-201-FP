package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    //   @Value("${application.message:Hello World}")
    //private String message = "Hello World";

  /*  @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/foo")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }*/

    @GetMapping("/")
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        //model.addAttribute("name", name);
        return "loginPage";
    }

    @GetMapping("/index")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}
