package com.tacho.applacation.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.Date;
import java.util.List;

@Entity
@Data
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "id",required = true,example = "10")
    private Long id;
    private Date createTime = new Date();
    @NotNull
    @Size(min=5,message = "长度必须为5")
    @Schema(description = "名称",required = true,example = "我的制造")
    private String name;
    @NotNull
    @ManyToMany()
    @Size(min=1,message = "必须至少有一个配料")
    @Schema(description = "配方",required = true)
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
