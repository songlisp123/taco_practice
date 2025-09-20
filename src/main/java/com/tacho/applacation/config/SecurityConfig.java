package com.tacho.applacation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//public class SecurityConfig {
//
//    private UserDetails userDetails;
//
//    public SecurityConfig(UserDetails userDetails) {
//        this.userDetails = userDetails;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();     //使用 bcrypt 强哈希加密
//    }
//
//}
