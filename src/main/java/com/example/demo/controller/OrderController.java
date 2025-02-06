package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<String> getOrders() {
        return ResponseEntity.ok("Orders API is working!");
    }

    @PostMapping("/{productId}/{quantity}")
    public ResponseEntity<Order> createOrder(@PathVariable Long productId, @PathVariable int quantity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(productId, quantity));
    }
}
