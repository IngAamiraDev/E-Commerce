package com.icodeapp.ecommerce.application.repository;

import com.icodeapp.ecommerce.domain.Order;
import com.icodeapp.ecommerce.domain.User;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
    public Iterable<Order> getOrdersByUser(User user);
}
