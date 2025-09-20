package com.tacho.applacation.controller;

import com.tacho.applacation.entity.Ingredient;
import com.tacho.applacation.entity.Taco;
import com.tacho.applacation.entity.TacoOrder;
import com.tacho.applacation.entity.User;
import com.tacho.applacation.inteface.IngredientRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.tacho.applacation.entity.Ingredient.Type;

import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes(names = "tacoOrder")
public class DesignTacoController {

    private static final Logger logger = Logger.getLogger("taco");
    private final IngredientRepository repository;

    @Autowired
    public DesignTacoController(IngredientRepository repository) {
        this.repository = repository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = repository.findAll();;
        Type[] types = Type.values();
        for (Type type:types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients,type));
        }

    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(HttpSession session,Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "design";
    }

    private Iterable<Ingredient> filterByType(
            Iterable<Ingredient> ingredients, Type type) {
        return StreamSupport.stream(ingredients.spliterator(),false)
                .filter(e->e.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processTaco(
            @Valid Taco taco , Errors errors,
            @ModelAttribute TacoOrder tacoOrder) {

        System.out.println(errors);
        if (errors.hasErrors())
            return "design";
        tacoOrder.addTaco(taco);
        log.info("处理玉米饼：{}",taco);
        logger.info("处理玉米饼"+taco.toString());
        return "redirect:/orders/current";
    }
}
/*
这个程序目前能做什么？你能为一份taco创建一个订单，并通过将taco对象与表单进行绑定
随后将绑定后的taco对象储存在tacoOrders中
 */