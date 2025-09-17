package com.tacho.applacation.controller;

import com.tacho.applacation.entity.User;
import com.tacho.applacation.entity.UserOrders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/user/")
@SessionAttributes(names = "userOrders")
public class userRegController {

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    @ModelAttribute(name = "userOrders")
    public UserOrders userOrders() {
        return new UserOrders();
    }

    @GetMapping("reg")
    public String reg() {
        return "register";
    }

    @PostMapping("reg")
    public String regComplete(
            @Validated User user,Errors error,
            @ModelAttribute UserOrders userOrders,
            SessionStatus SessionStatus)
    {
        if (error.hasErrors())
            return "register";
        userOrders.add(user);
        SessionStatus.setComplete();
        return "regComplete";
    }
}
