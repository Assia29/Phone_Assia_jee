package com.example.phone_assia_jee.web;



import com.example.phone_assia_jee.dao.entites.Product;
import com.example.phone_assia_jee.service.ProductService;
import com.example.phone_assia_jee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService adminService;

    @Autowired
    private ProductService productService;

    @GetMapping("/login")
    public String showAdminLoginPage() {
        return "admin-login";
    }

    @PostMapping("/login")
    public String loginAdmin(@RequestParam String username, @RequestParam String password, Model model) {
        if (adminService.authenticateAdmin(username, password)) {
            return "redirect:/admin/products";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "admin-login";
        }
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin-product-list";
    }

    @GetMapping("/products/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "admin-product-add";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "admin-product-edit";
    }

    @PostMapping("/products/edit/{id}")
    public String editProduct(@PathVariable Long id, @ModelAttribute Product product) {
        productService.updateProduct(id, product);
        return "redirect:/admin/products";
    }

    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/products";
    }
}
