package com.youbikerental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // 使用新方式來禁用CSRF保護
            .authorizeHttpRequests(auth -> auth
            	    .requestMatchers("/", "/home", "/register", "/api/users/register").permitAll()  // 確保註冊API不需要認證
            	    .anyRequest().authenticated())
            //.formLogin(form -> form
            //    .loginPage("/login")
            //    .permitAll())
            .logout().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
