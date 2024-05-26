package com.example.phone_assia_jee.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserController {
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }


}
