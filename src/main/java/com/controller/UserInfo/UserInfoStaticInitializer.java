package com.controller.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


// This class helps us to initialize a static variable "UserInfoRepo" in UserInfoController class
@Component
public final class UserInfoStaticInitializer {
    //autowired the static variable
    @Autowired
    private UserInfoRepository repo;

    //just do this
    @Autowired
    private ApplicationContext context;

    //postConstruct the method
    @PostConstruct
    public void Init() {
        UserInfoController.setUserInfoRepository(repo);
    }
}
