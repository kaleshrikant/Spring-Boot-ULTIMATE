package com.alibou.example.dto;

public record OrderRecord(
        String customerName,

        String productName,

        int quantity
) {
}
