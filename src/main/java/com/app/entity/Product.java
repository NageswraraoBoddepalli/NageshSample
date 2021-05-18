package com.app.entity;

import lombok.Data;

@Data
public class Product {
    private String productId;
    private String productName;
    private String unitOfMeasure;
    private String status;

    public Product(String productId, String productName, String unitOfMeasure) {
        this.productId = productId;
        this.productName = productName;
        this.unitOfMeasure = unitOfMeasure;
    }
}
