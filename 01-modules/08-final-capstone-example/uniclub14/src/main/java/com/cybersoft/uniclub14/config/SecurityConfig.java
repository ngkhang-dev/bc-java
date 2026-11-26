package com.cybersoft.uniclub14.config;

import com.cybersoft.uniclub14.filter.CustomTokenFilter;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(
      HttpSecurity httpSecurity,
      CustomTokenFilter customTokenFilter,
      CorsConfigurationSource corsConfigurationSource)
      throws Exception {
    return httpSecurity
        .csrf(csrf -> csrf.disable())
        .cors(cors -> cors.configurationSource(corsConfigurationSource))
        .authorizeHttpRequests(request -> {
          // Quyết định URL request nào được truy cập tự do

          // Cho phép request URL không cần chứng thực.
          // Cách 1 (recommendation): set up tập trung tại 1 nơi
          // request.requestMatchers("/auth/sign-in").permitAll(); // Mọi method
          // request.requestMatchers(HttpMethod.POST, "/auth/sign-in").permitAll(); // Chỉ cho
          // method POST
          request
              .requestMatchers("/auth/**")
              .permitAll(); // Cho phép mọi method với URL bắt đầu /auth
          // Cách 2: có thể sử dụng annotation @Role, @PreAuthorize ở Controller nhưng khó quản lý

          // Authorization
          request.requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN");

          // Bất kỳ request nào cũng phải chứng thực
          request.anyRequest().authenticated();
        })
        .addFilterBefore(customTokenFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {

    CorsConfiguration configuration = new CorsConfiguration();

    // Cho phép Frontend truy cập
    configuration.setAllowedOrigins(
        Arrays.asList("http://127.0.0.1:5500", "http://localhost:5500"));

    // Cho phép HTTP Methods
    configuration.setAllowedMethods(
        Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));

    // Cho phép các HTTP Headers
    configuration.setAllowedHeaders(
        Arrays.asList("Authorization", "Content-Type", "X-Requested-With", "X-Request-ID"));

    // Cho phép expose response headers
    configuration.setExposedHeaders(Arrays.asList("Authorization", "X-Request-ID"));

    // Nếu sử dụng Cookie thì bật true.
    // Nếu chỉ sử dụng JWT Bearer Token thì có thể để false.
    configuration.setAllowCredentials(false);

    // Thời gian cache kết quả preflight (giây)
    // configuration.setMaxAge(3600L);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

    source.registerCorsConfiguration("/**", configuration);

    return source;
  }
}
