package com.tacho.applacation.Base;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco {
    @Schema(description = "id",required = true,example = "10")
    private Integer id;
    private Date createTime = new Date();
    @NotNull
    @Size(min=5,message = "长度必须为5")
    @Schema(description = "名称",required = true,example = "我的制造")
    private String name;
    @NotNull
    @Size(min=1,message = "必须至少有一个配料")
    @Schema(description = "配方",required = true)
    private List<Ingredient> ingredients;
}
