package com.alibou.example.controller;

import com.alibou.example.dto.Order;
import com.alibou.example.dto.OrderRecord;
import org.springframework.web.bind.annotation.*;

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

    // http://localhost:9090/hello/Shrikant.Kale
    @GetMapping("/hello/{user-name}")
    public String pathVar(
            @PathVariable("user-name") String userName
    ) {
        return "Hello user : " +userName;
    }

    // http://localhost:9090/hello/user?user-first-name=Shrikant&user-last-name=Kale
    @GetMapping("/hello/user")
    public String paramVar(
            @RequestParam("user-first-name") String userFirstName,
            @RequestParam("user-last-name") String userLastName
    ) {
        return "Hello user : " +userFirstName+ "  "+userLastName;
    }

}
