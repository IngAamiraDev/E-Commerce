package com.icodeapp.ecommerce.application.service;

import com.icodeapp.ecommerce.application.repository.OrderRepository;
import com.icodeapp.ecommerce.domain.Order;
import com.icodeapp.ecommerce.domain.User;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order){
        return  orderRepository.createOrder(order);
    }

    public Iterable<Order> getOrders(){
        return  orderRepository.getOrders();
    }

    public Iterable<Order> getOrdersByuser(User user){
        return orderRepository.getOrdersByUser(user);
    }
}
