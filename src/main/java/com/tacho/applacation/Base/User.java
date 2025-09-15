package com.tacho.applacation.Base;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    @Size(min = 8,max = 15,message = "密码错误！")
    private String password;
    private String email;
    private String phone;
    private List<TacoOrder> orders = new ArrayList<>();
    private Image image;
    private String description;

    public void add(TacoOrder order) {
        orders.add(order);
    }
}
