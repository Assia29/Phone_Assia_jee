package com.example.phone_assia_jee.web;

import org.springframework.ui.Model;
import com.example.phone_assia_jee.dao.entites.Product;
import com.example.phone_assia_jee.dao.entites.User;
import com.example.phone_assia_jee.dao.repositories.ProductRepository;
import com.example.phone_assia_jee.service.CartService;
import com.example.phone_assia_jee.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/products")
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/product-list")
    public String listProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product-list";
    }

//    @GetMapping("/view/{id}")
//    public String viewProduct(@PathVariable("id") Long id, Model model) {
//        Product product = productService.findById(id);
//        model.addAttribute("product", product);
//        return "product-view";  // Create a view template named "product-view.html" to display product details
//    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") Long id, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        if (user != null) {
            cartService.addToCart(user, id);
        }
        return "redirect:/products/product-list";
    }
}




