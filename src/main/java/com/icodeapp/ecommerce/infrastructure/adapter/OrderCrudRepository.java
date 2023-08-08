package com.icodeapp.ecommerce.infrastructure.adapter;

import com.icodeapp.ecommerce.infrastructure.entity.OrderEntity;
import com.icodeapp.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderCrudRepository extends CrudRepository<OrderEntity, Integer> {
    public Iterable<OrderEntity> findByUser(UserEntity userEntity);
}
