package com.icodeapp.ecommerce.application.repository;

import com.icodeapp.ecommerce.domain.Product;
import com.icodeapp.ecommerce.domain.User;

public interface ProductRepository {
    Iterable<Product> getProducts();
    Iterable<Product> getProductsByUser(User user);
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);
}
