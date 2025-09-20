package com.tacho.applacation.converter;

import com.tacho.applacation.entity.Ingredient;
import com.tacho.applacation.inteface.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class converter implements Converter<String, Ingredient> {

   private IngredientRepository repository;

   @Autowired
   public converter(IngredientRepository repository) {
       this.repository = repository;
   }

    @Override
    public Ingredient convert(String id) {
        return repository.findById(id).orElse(null);
    }
}
