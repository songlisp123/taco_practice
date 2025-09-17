package com.tacho.applacation.controller;

import com.tacho.applacation.entity.TacoOrder;
import com.tacho.applacation.entity.User;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.logging.Logger;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class orderController {

    private static final Logger logger = Logger.getLogger("taco");
    private final JdbcOrderRepository repository;

    @Autowired
    public orderController(JdbcOrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/current")
    public String orderForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        logger.info("欢迎进入订单页面……");
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid TacoOrder tacoOrder, Errors errors,
            SessionStatus sessionStatus,
            HttpSession session,
            Model model)
    {
        if (errors.hasErrors())
            return "orderForm";
        repository.save(tacoOrder);
        log.info("提交订单，{}",tacoOrder);
        logger.info("提交订单:"+ tacoOrder);
        User user = (User) session.getAttribute("user");
        user.add(tacoOrder);
        model.addAttribute("user",user);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
