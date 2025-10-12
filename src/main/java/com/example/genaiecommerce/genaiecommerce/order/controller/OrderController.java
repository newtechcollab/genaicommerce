package com.example.genaiecommerce.genaiecommerce.order.controller;

import com.example.genaiecommerce.genaiecommerce.order.model.Order;
import com.example.genaiecommerce.genaiecommerce.order.model.OrderRequest;
import com.example.genaiecommerce.genaiecommerce.order.service.OrderService;
import com.example.genaiecommerce.genaiecommerce.product.model.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            Order createdOrder = orderService.createOrder(orderRequest);
            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Other endpoints can be defined here
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}