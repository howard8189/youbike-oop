package com.youbikerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/") // 基礎路徑設定
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

    @GetMapping("/map")
    public String showMapForm() {
        return "map";
    }
    
    // 使用者登入後導向，假設簡化處理：所有已認證的用戶都跳轉至此
    @GetMapping("/userlogin")
    public String userLogin(@AuthenticationPrincipal UserDetails userDetails) {
        return "userlogin";
    }
    
    // 維修頁面入口
    @GetMapping("/maintenance")
    public String maintenanceLogin(@AuthenticationPrincipal UserDetails userDetails) {
        return "maintenance";
    }

    // 維修人員查看車輛狀態
    @GetMapping("/maintenance/status")
    public String maintenanceStatus() {
        return "mstatus";
    }

    // 維修人員查看車輛狀態
    @GetMapping("/maintenance/search")
    public String maintenanceSearch() {
        return "msearch";
    }
    
    // 維修人員查看車輛狀態
    @GetMapping("/maintenance/edit")
    public String maintenanceEdit() {
        return "medit";
    }
    

    @GetMapping("/userdashboard")
    public String userdashboardlogin() {
        return "userdashboard";
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
    @GetMapping("/Map")
    public String getMapForm() {
        return "Map";
    }
    @GetMapping("/UserInformation")
    public String getUserInformationForm() {
        return "UserInformation";
    }
    @GetMapping("/returnbike")
    public String getreturnbikeForm(){
        return "returnbike";
    }
    @GetMapping("/rentbike")
    public String getrentbikeForm(){
        return "rentbike";
    }

    @GetMapping("/rental")
    public String getrentalForm(){
        return "rental";
    }
}
