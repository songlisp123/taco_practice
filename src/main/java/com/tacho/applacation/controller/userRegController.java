package com.tacho.applacation.controller;

import com.tacho.applacation.Base.User;
import com.tacho.applacation.Base.UserOrders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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

    @PostMapping("reg/complete")
    public String regComplete(
            User user,
            @ModelAttribute UserOrders userOrders,
            SessionStatus SessionStatus)
    {
//        System.out.println("注册成功！");
//        System.out.println("用户名："+user.getName());
//        System.out.println("密码："+user.getPassword());
        userOrders.add(user);
        SessionStatus.setComplete();
        return "regComplete";
    }
}
