package com.tacho.applacation.converter;

import com.tacho.applacation.Base.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class converter implements Converter<String, Ingredient> {

    private Map<String,Ingredient> ingredientMap = new HashMap<>();
    public converter() {
        ingredientMap.put("FLTO",
                new Ingredient("FLTO", "玉米薄馅饼", Ingredient.Type.WRAP));
        ingredientMap.put("COTO",
                new Ingredient("COTO", "玉米饼", Ingredient.Type.WRAP));
        ingredientMap.put("GRBF",
                new Ingredient("GRBF", "牛肉", Ingredient.Type.PROTEIN));
        ingredientMap.put("CARN",
                new Ingredient("CARN", "羊肉", Ingredient.Type.PROTEIN));
        ingredientMap.put("TMTO",
                new Ingredient("TMTO", "土豆泥", Ingredient.Type.VEGGIES));
        ingredientMap.put("LETC",
                new Ingredient("LETC", "甜紫菜", Ingredient.Type.VEGGIES));
        ingredientMap.put("CHED",
                new Ingredient("CHED", "芝士", Ingredient.Type.CHEESE));
        ingredientMap.put("JACK",
                new Ingredient("JACK", "泡芙", Ingredient.Type.CHEESE));
        ingredientMap.put("SLSA",
                new Ingredient("SLSA", "沙拉", Ingredient.Type.SAUCE));
        ingredientMap.put("SRCR",
                new Ingredient("SRCR", "奶油", Ingredient.Type.SAUCE));

    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
