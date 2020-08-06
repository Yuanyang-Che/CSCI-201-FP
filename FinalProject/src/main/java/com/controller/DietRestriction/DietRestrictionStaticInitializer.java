package com.controller.DietRestriction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DietRestrictionStaticInitializer {
    @Autowired
    private DietRestrictionRepository repo;

    //just do this
    @Autowired
    private ApplicationContext context;

    //postConstruct the method
    @PostConstruct
    public void Init() {
        DietRestrictionController.setDietRestrictionRepository(repo);
    }
}


