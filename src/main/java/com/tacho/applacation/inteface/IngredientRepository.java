package com.tacho.applacation.inteface;

import com.tacho.applacation.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository
        extends CrudRepository<Ingredient,String> {
}
