package com.example.genaiecommerce.genaiecommerce.order.repository;


import com.example.genaiecommerce.genaiecommerce.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}