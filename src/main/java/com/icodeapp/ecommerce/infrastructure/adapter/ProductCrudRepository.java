package com.icodeapp.ecommerce.infrastructure.adapter;

import com.icodeapp.ecommerce.infrastructure.entity.ProductEntity;
import com.icodeapp.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository  extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByUserEntity (UserEntity userEntity);
}
