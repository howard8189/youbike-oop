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
            	    .requestMatchers("/", "/home", "/register", "/** ","/api/users/register","/rentbike","/login","/returnbike","/UserLogin","/UserInformation","/AfterLogin","/Map","/Charges1","/images/**").permitAll()  // 確保註冊API不需要認證
            	    .anyRequest().authenticated())
            /* .formLogin(form -> form
                .loginPage("/login")
                .permitAll())*/
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/AfterLogin", true) // 登录成功后的默认重定向页面
                .failureUrl("/login?error=true"); // 登录失败后的重定向页面，并附带错误参数
            //.logout().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
