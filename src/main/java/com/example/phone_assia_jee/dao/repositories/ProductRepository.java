package com.example.phone_assia_jee.dao.repositories;


import com.example.phone_assia_jee.dao.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
