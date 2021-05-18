package com.app.dao;

import com.app.entity.Order;
import com.app.entity.Shipment;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailsResponse {
    private Order order;
    private Shipment shipment;
}
