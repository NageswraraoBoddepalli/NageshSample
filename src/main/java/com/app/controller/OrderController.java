package com.app.controller;

import com.app.common.LoggerUtil;
import com.app.dao.OrderDetailsResponse;
import com.app.dao.OrderRequest;
import com.app.entity.Order;
import com.app.entity.Shipment;
import com.app.service.OrderService;
import com.app.service.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ShipmentService shipmentService;

    @PostMapping("/getOrderDetails")
    public ResponseEntity<?> getOrderDetails(@RequestBody OrderRequest orderRequest) throws ExecutionException, InterruptedException {
        log.info("ProductList value{}", LoggerUtil.encodeString(orderRequest.toString()));
        orderService.getInitializeOrders();
        shipmentService.getInitializeShipments();
        String orderId = orderRequest.getOrderId();
        CompletableFuture<Order> orderById = orderService.getOrderById(orderId);
        CompletableFuture<Shipment> shipmentByOrderId = shipmentService.getShipmentByOrderId(orderId);
        CompletableFuture.allOf(orderById, shipmentByOrderId).join();
        OrderDetailsResponse response= new OrderDetailsResponse(orderById.get(), shipmentByOrderId.get());
        log.info("ProductList value{}", LoggerUtil.encodeString(response.toString()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
