package com.icodeapp.ecommerce.infrastructure.adapter;

import com.icodeapp.ecommerce.application.repository.OrderRepository;
import com.icodeapp.ecommerce.domain.Order;
import com.icodeapp.ecommerce.domain.User;
import com.icodeapp.ecommerce.infrastructure.mapper.OrderMapper;
import com.icodeapp.ecommerce.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * Esta clase implementa la interfaz OrderRepository y proporciona acceso a los datos de órdenes en la base de datos.
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderCrudRepository orderCrudRepository;
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;

    public OrderRepositoryImpl(OrderCrudRepository orderCrudRepository, OrderMapper orderMapper, UserMapper userMapper) {
        this.orderCrudRepository = orderCrudRepository;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Order createOrder(Order order) {
        return orderMapper.toOrder(orderCrudRepository.save(orderMapper.toOrderEntity(order)));
    }

    @Override
    public Iterable<Order> getOrders() {
        return orderMapper.toOrders(orderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> getOrdersByUser(User user) {
        return orderMapper.toOrders(orderCrudRepository.findByUser(userMapper.toUserEntity(user)));
    }

}
