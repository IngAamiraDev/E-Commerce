package com.icodeapp.ecommerce.application.repository;

import com.icodeapp.ecommerce.domain.Order;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
}
