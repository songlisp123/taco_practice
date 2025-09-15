package com.tacho.applacation.controller;

import com.tacho.applacation.Base.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/user/")
@SessionAttributes("user")
public class userController {

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    @GetMapping("login")
    public String loginConfirm() {
        return "loginConfirm";
    }

    @PostMapping("login/complete")
    public String loginComplete(@ModelAttribute User user, HttpSession session) {
        session.setAttribute("user",user);
        return "redirect:/";
    }
}
