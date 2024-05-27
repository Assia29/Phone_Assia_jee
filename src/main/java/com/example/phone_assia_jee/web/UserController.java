package com.example.phone_assia_jee.web;


import com.example.phone_assia_jee.dao.entites.User;
import com.example.phone_assia_jee.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;
import com.example.phone_assia_jee.service.UserService;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //signup--------------------
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "login";
    }

    //singin-----------------------------
    @GetMapping("/login")
    public String  showSignInForm(Model model) {
        return "login";
    }
    @PostMapping("/process_login")
    public String processLogin(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        User user = userRepository.findByUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Login successful
            session.setAttribute("loggedInUser", user);
            model.addAttribute("username", username);
            return "redirect:/test";
        } else {
            // Login failed
            model.addAttribute("error", "Invalid username or password.");
            return "redirect:/users/login";
        }
    }


    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
