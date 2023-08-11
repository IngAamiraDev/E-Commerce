package com.icodeapp.ecommerce.application.repository;

import com.icodeapp.ecommerce.domain.Product;
import com.icodeapp.ecommerce.domain.Stock;

import java.util.List;

public interface StockRepository {
    Stock saveStock(Stock stock);
    List<Stock> getStockByProduct(Product product);
}
