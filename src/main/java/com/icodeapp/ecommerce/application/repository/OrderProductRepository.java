package com.icodeapp.ecommerce.application.repository;

import com.icodeapp.ecommerce.domain.Order;
import com.icodeapp.ecommerce.domain.OrderProduct;

import java.util.List;

public interface OrderProductRepository {
    public OrderProduct create (OrderProduct orderProduct);
    public Iterable<OrderProduct>  getOrderProducts();
    public List<OrderProduct> getOrdersProductByOrder(Order order);
}
