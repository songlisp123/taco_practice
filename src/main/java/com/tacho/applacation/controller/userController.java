package com.tacho.applacation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user/")
public class userController {

    @GetMapping("login")
    public String loginConfirm() {
        return "loginConfirm";
    }

    @PostMapping("login/complete")
    public String loginComplete() {
        return "redirect:/";
    }
}
