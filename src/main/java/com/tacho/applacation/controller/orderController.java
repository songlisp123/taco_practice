package com.tacho.applacation.controller;

import com.tacho.applacation.Base.TacoOrder;
import com.tacho.applacation.Base.User;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class orderController {

    @GetMapping("/current")
    public String orderForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid TacoOrder tacoOrder, Errors errors,
            SessionStatus sessionStatus,
            HttpSession session)
    {
        if (errors.hasErrors())
            return "orderForm";
        log.info("提交订单，{}",tacoOrder);
        User user = (User) session.getAttribute("user");
        user.add(tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
