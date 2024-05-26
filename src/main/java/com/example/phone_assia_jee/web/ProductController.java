package com.example.phone_assia_jee.web;

import ch.qos.logback.core.model.Model;
import com.example.phone_assia_jee.dao.entites.Product;
import com.example.phone_assia_jee.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/products")
@Controller
public class ProductController {
    @GetMapping("/product-list")
    public String showProducts() {
        return "product-list";
    }
    @Autowired
    private ProductRepository productRepository;




}




