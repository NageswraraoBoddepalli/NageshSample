package com.app.controller;

import com.app.entity.Product;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Test
    public void createProductTest(){
        String prod = "\"{\\\"productId\\\":\\\"Prod4\\\",\\\"productName\\\":\\\"Shoe\\\",\\\"unitOfMeasure\\\":\\\"EACH\\\"}\"";
        Gson g = new Gson();
        Product product = g.fromJson(prod, Product.class);
        Assertions.assertNotNull(productController.createProduct(product));
    }
}
