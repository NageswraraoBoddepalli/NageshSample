package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Shipment {
    @JsonIgnore
    private String orderId;
    private String shipmentId;
    private String productId;
    private Date shipmentDate;
    private Double qty;
}
