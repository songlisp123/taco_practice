package com.tacho.applacation.Base;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min=5,message = "长度必须为5")
    private String name;
    @NotNull
    @Size(min=1,message = "必须至少有一个配料")
    private List<Ingredient> ingredients;
}
