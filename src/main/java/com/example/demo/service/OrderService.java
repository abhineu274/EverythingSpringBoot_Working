package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public Order createOrder(Long productId, int quantity) {
        Product product = productService.getProductById(productId);
        if (product.getQuantity() < quantity) {
            throw new IllegalStateException("Insufficient stock");
        }

        product.setQuantity(product.getQuantity() - quantity);
        productService.addProduct(product);

        Order order = new Order(null, product, quantity, LocalDate.now());
        return orderRepository.save(order);
    }
}
