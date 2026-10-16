package com.cybersoft.demospringboot.request;

import java.math.BigDecimal;

public class UpdateProductRequest {
    private String productName;
    private BigDecimal price;
    private int quantity;

    public UpdateProductRequest(BigDecimal price, String productName, int quantity) {
        this.price = price;
        this.productName = productName;
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
