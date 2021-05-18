package com.app.service;

import com.app.common.LoggerUtil;
import com.app.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class OrderService {

    List<Order> orders = new ArrayList<>();

    public void getInitializeOrders() {
        orders.add(new Order("Order1", "ProdId", 2.0));
    }

    @Async
    public CompletableFuture<Order> getOrderById(String orderId) {
        log.info("orderId value{}", LoggerUtil.encodeString(orderId));
        Optional<Order> order = orders.stream()
                .filter(x -> x.getOrderId().equals(orderId))
                .findFirst();
        log.info("order val{}",LoggerUtil.encodeString(order.toString()));
        return CompletableFuture.completedFuture(order.get());
    }

}
