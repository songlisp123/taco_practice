package com.tacho.applacation.controller;

import com.tacho.applacation.Base.Ingredient;
import com.tacho.applacation.Base.Taco;
import com.tacho.applacation.Base.TacoOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.tacho.applacation.Base.Ingredient.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")

public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "玉米薄馅饼", Type.WRAP),
                new Ingredient("COTO", "玉米饼", Type.WRAP),
                new Ingredient("GRBF", "牛肉", Type.PROTEIN),
                new Ingredient("CARN", "羊肉", Type.PROTEIN),
                new Ingredient("TMTO", "土豆泥", Type.VEGGIES),
                new Ingredient("LETC", "甜紫菜", Type.VEGGIES),
                new Ingredient("CHED", "芝士", Type.CHEESE),
                new Ingredient("JACK", "泡芙", Type.CHEESE),
                new Ingredient("SLSA", "沙拉", Type.SAUCE),
                new Ingredient("SRCR", "奶油", Type.SAUCE)
        );

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
    public String showDesignForm() {
        return "design";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
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
        return "redirect:/orders/current";
    }
}
/*
这个程序目前能做什么？你能为一份taco创建一个订单，并通过将
 */