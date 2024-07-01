package com.alibou.example.controller;

import com.alibou.example.dto.Order;
import com.alibou.example.dto.OrderRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from my first controller";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ) {
        return "Request accepted and message is : "+message;
    }

    @PostMapping("/post-order")
    public String postOrder(
            @RequestBody Order order
    ) {
        return "Request accepted and order is : "+order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord orderRecord
    ) {
        return "Request accepted and order is : "+orderRecord.toString();
    }
}
