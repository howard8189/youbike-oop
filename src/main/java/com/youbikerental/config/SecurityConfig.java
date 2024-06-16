package com.youbikerental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, PersistentTokenRepository tokenRepository) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/home", "/login", "/register", "/api/users/register", "/images/**").permitAll()
                .requestMatchers("/maintenance", "/maintenance/**", "/userlogin", "/api/users/maintenance", "/api/bikes/**", "/rental").authenticated())
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/userlogin", true)
                .permitAll())
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID", "remember-me")
                .permitAll())
            .rememberMe(rememberMe -> rememberMe
                .tokenRepository(tokenRepository)
                .tokenValiditySeconds(86400)); // 24 hours

        // Enable session management
        http.sessionManagement(session -> session
            .sessionFixation(sessionFixation -> sessionFixation.migrateSession())
            .invalidSessionUrl("/login")
            .maximumSessions(1)
            .expiredUrl("/login"));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
