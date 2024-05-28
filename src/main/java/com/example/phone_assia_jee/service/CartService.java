package com.example.phone_assia_jee.service;



import com.example.phone_assia_jee.dao.entites.Cart;
import com.example.phone_assia_jee.dao.entites.Product;
import com.example.phone_assia_jee.dao.entites.User;
import com.example.phone_assia_jee.dao.repositories.CartRepository;
import com.example.phone_assia_jee.dao.repositories.ProductRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addToCart(User user, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("Product not found"));
        Cart cart = cartRepository.findByUser(user).orElse(new Cart(user));
        cart.addProduct(product);
        cartRepository.save(cart);
    }


}
