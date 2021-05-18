package com.app.controller;

import com.app.common.LoggerUtil;
import com.app.entity.Product;
import com.app.entity.Product2;
import com.app.entity.ProductList;
import com.app.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        log.info("product value{}",LoggerUtil.encodeString(product.toString()));
        productService.getInitializeProducts();
        Product response = productService.createProduct(product);
        log.info("response returned from product service{}",LoggerUtil.encodeString(response.toString()));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/sortProducts")
    public ResponseEntity<?> sortProducts(@RequestBody ProductList productList) {
        log.info("ProductList value{}",LoggerUtil.encodeString(productList.toString()));
        List<Product2> products = productList.getProductList();
        List<Product2> response = productService.getListOfSortProducts(products);
        log.info("response returned from product service{}",LoggerUtil.encodeString(response.toString()));
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

}
