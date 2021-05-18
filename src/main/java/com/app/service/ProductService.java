package com.app.service;

import com.app.common.LoggerUtil;
import com.app.entity.Product;
import com.app.entity.Product2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

    List<Product> products = new ArrayList<>();

    public void getInitializeProducts() {
        Product prod1 = new Product("Prod1", "Shirt", "EACH");
        Product prod2 = new Product("Prod2", "Trousers", "EACH");
        Product prod3 = new Product("Prod3", "Tie", "EACH");
        Collections.addAll(products, prod1, prod2, prod3);
    }


    public Product createProduct(Product product) {
        log.info("result value{}",LoggerUtil.encodeString(product.toString()));
        boolean exists = products.stream()
                                 .anyMatch(x -> x.getProductId().equals(product.getProductId()));
        if(exists) {
            log.error("Product already exists for the given ID: {}", LoggerUtil.encodeString(product.getProductId()));
            product.setStatus("Exists");
        } else {
            log.info("Product created successfully");
            product.setStatus("Created");
            products.add(product);
        }
        log.info("result value{}",LoggerUtil.encodeString(product.toString()));
        return product;
    }

    public List<Product2> getListOfSortProducts(List<Product2> products) {
        log.info("products value{}",LoggerUtil.encodeString(products.toString()));
        List<Product2> result = products.stream()
                .sorted(Comparator.comparing(Product2::getProductId).thenComparing(Product2::getLaunchDate).reversed())
                .collect(Collectors.toList());
        log.info("result value{}",LoggerUtil.encodeString(result.toString()));
        return result;
    }
}
