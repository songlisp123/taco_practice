package com.tacho.applacation.Base;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository
        extends CrudRepository<Ingredient,String> {
}
