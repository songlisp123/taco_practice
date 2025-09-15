package com.tacho.applacation.Base;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
