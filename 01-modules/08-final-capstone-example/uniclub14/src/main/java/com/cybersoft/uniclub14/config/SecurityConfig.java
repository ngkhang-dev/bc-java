package com.cybersoft.uniclub14.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> {
                    // Quyết định URL request nào được truy cập tự do

                    // Cho phép request URL không cần chứng thực.
                    // Cách 1 (recommendation): set up tập trung tại 1 nơi
                    // request.requestMatchers("/auth/sign-in").permitAll(); // Mọi method
                    // request.requestMatchers(HttpMethod.POST, "/auth/sign-in").permitAll(); // Chỉ cho phép method: POST
                    request.requestMatchers("/auth/**").permitAll(); // Cho phép mọi method với URL bắt đầu /auth
                    // Cách 2: có thể sử dụng annotation @Role, @PreAuthorize ở Controller nhưng khó quản lý

                    // Bất kỳ request nào cũng phải chứng thực
                    request.anyRequest().authenticated();
                })
                .build();
    }
}
