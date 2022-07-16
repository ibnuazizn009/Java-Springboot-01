package com.example.models.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.entities.Product;

public interface ProductRepositroy extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);
    
}
