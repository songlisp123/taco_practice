package com.tacho.applacation.Base;

import lombok.Data;

import java.util.List;

@Data
public class Taco {
    private String name;
    private List<Ingredient> ingredients;

//    public Taco() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(List<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    @Override
//    public String toString() {
//        return "Taco{" +
//                "name='" + name + '\'' +
//                ", ingredients=" + ingredients +
//                '}';
//    }
}
