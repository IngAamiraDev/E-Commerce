package com.icodeapp.ecommerce.infrastructure.adapter;

import com.icodeapp.ecommerce.application.repository.ProductRepository;
import com.icodeapp.ecommerce.domain.Product;
import com.icodeapp.ecommerce.domain.User;
import com.icodeapp.ecommerce.infrastructure.mapper.ProductMapper;
import com.icodeapp.ecommerce.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * Esta clase implementa la interfaz ProductRepository y proporciona acceso a los datos de productos en la base de datos.
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductCrudRepository productCrudRepository;
    private final ProductMapper productMapper;
    private final UserMapper userMapper;

    public ProductRepositoryImpl(ProductCrudRepository productCrudRepository, ProductMapper productMapper, UserMapper userMapper) {
        this.productCrudRepository = productCrudRepository;
        this.productMapper = productMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Iterable<Product> getProducts() {
        return productMapper.toProducts(productCrudRepository.findAll());
    }

    @Override
    public Iterable<Product> getProductsByUser(User user) {
        return productMapper.toProducts(productCrudRepository.findByUserEntity(userMapper.toUserEntity(user)));
    }

    @Override
    public Product getProductById(Integer id) {
        return productMapper.toProduct(productCrudRepository.findById(id).get());
    }

    @Override
    public Product saveProduct(Product product) {
        return productMapper.toProduct(productCrudRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public void deleteProductById(Integer id) {
        productCrudRepository.deleteById(id);
    }

}
