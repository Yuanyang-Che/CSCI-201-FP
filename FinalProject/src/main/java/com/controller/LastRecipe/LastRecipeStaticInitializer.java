package com.controller.LastRecipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LastRecipeStaticInitializer {
    @Autowired
    private LastRecipeRepository repo;

    //just do this
    @Autowired
    private ApplicationContext context;

    //postConstruct the method
    @PostConstruct
    public void Init() {
        LastRecipeController.setLastRecipeRepository(repo);
    }
}
