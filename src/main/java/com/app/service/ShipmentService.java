package com.app.service;

import com.app.common.LoggerUtil;
import com.app.entity.Shipment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class ShipmentService {

    List<Shipment> shipments = new ArrayList<>();

    public void getInitializeShipments() {
        shipments.add(new Shipment("Order1", "Ship1", "Prod1", new Date(2021-02-2019), 2.0));
    }

    @Async
    public CompletableFuture<Shipment> getShipmentByOrderId(String orderId) {
        log.info("orderId value{}", LoggerUtil.encodeString(orderId));
        Optional<Shipment> shipment = shipments.stream()
                .filter(x -> x.getOrderId().equals(orderId))
                .findFirst();
        log.info("shipment value{}", LoggerUtil.encodeString(shipment.toString()));
        return CompletableFuture.completedFuture(shipment.get());
    }
}
