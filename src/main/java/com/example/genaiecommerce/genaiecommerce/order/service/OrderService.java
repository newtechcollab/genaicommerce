package com.example.genaiecommerce.genaiecommerce.order.service;

import com.example.genaiecommerce.genaiecommerce.order.model.Order;
import com.example.genaiecommerce.genaiecommerce.order.model.OrderRequest;
import com.example.genaiecommerce.genaiecommerce.order.repository.OrderRepository;
import com.example.genaiecommerce.genaiecommerce.product.model.Product;
import com.example.genaiecommerce.genaiecommerce.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    public Order createOrder(OrderRequest orderRequest) {
        // 1. Call Product Service to check for product existence and inventory
        Product product = productService.getProductById(orderRequest.getProductId());

        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }
        if (product.getInventory() < orderRequest.getQuantity()) {
            throw new IllegalArgumentException("Insufficient stock");
        }

        // 2. Business logic to create the order
        Order order = new Order();
        order.setUserId(orderRequest.getUserId());
        order.setProductId(orderRequest.getProductId());
        order.setQuantity(orderRequest.getQuantity());      
        order.setTotalPrice(product.getPrice().multiply(new java.math.BigDecimal(order.getQuantity())));
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");

        // 3. Save the order
        // In a real transactional scenario, you'd also call the product service to update inventory.
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
