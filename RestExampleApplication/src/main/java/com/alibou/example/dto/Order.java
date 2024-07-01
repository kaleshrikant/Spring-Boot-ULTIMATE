package com.alibou.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @JsonProperty("c-Name")
    private String customerName;

    @JsonProperty("p-Name")
    private String productName;

    @JsonProperty("quantity")
    private int quantity;

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
