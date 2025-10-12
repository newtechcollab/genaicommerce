package com.example.genaiecommerce.genaiecommerce.order.model;


public class OrderRequest {
    
    private Long userId; // In a real app, this would be a relation
    private Long productId;
    private Integer quantity;

    public Long getUserId() {
        return userId;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
