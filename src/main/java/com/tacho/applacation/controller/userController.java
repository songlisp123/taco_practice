package com.tacho.applacation.controller;

import com.tacho.applacation.ApplacationApplication;
import com.tacho.applacation.Base.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String loginComplete(@ModelAttribute User user,HttpSession session) {
        ApplacationApplication.logger.info("user:"+user);
        session.setAttribute("user",user);
        return "redirect:/design";
    }

    @GetMapping("current")
    public String current(HttpSession session) {
        User user = (User) session.getAttribute("user");
        ApplacationApplication.logger.info("user:"+user);
        return "current";
    }
}
