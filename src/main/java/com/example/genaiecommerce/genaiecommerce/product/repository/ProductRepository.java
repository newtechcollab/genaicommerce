package com.example.genaiecommerce.genaiecommerce.product.repository;

import com.example.genaiecommerce.genaiecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
