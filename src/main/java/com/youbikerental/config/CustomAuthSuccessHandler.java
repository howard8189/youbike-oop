package com.youbikerental.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import com.youbikerental.model.User;

public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {
	
    private static final Logger logger = LoggerFactory.getLogger(CustomAuthSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        User authenticatedUser = (User) authentication.getPrincipal();  // Casting to User assuming that is the principal object

        logger.info("Login successful for user: {}", authenticatedUser.getPhoneNumber());

        if ("aaaaaaaaaa".equals(authenticatedUser.getPhoneNumber())) {
            logger.info("Redirecting to maintenance page for admin user.");
            response.sendRedirect("/maintenance");  // 維修人員的導向頁面
        } else {
            logger.info("Redirecting to user login page.");
            response.sendRedirect("/userlogin/" + authenticatedUser.getId());  // 根據用戶 ID 導向用戶頁面
        }
    }
}
