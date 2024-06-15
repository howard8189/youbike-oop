package com.youbikerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/") // 可以設定基礎路徑，如需
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }
    @GetMapping("/UserLogin")
    public String showUserLoginForm() {
        return "UserLogin";
    }
    @GetMapping("/Charges1")
    public String getCharges1Form() {
        return "Charges1";
    }
    @GetMapping("/AfterLogin")
    public String getAfterLoginForm() {
        return "AfterLogin";
    }
    
}
