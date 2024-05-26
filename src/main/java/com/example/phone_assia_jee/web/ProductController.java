package com.example.phone_assia_jee.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/products")
@Controller
public class ProductController {
    @GetMapping("/product-list")
    public String showProducts() {
        return "product-list";
    }
}
