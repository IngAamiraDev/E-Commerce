package com.icodeapp.ecommerce.infrastructure.adapter;

import com.icodeapp.ecommerce.application.repository.StockRepository;
import com.icodeapp.ecommerce.domain.Product;
import com.icodeapp.ecommerce.domain.Stock;
import com.icodeapp.ecommerce.infrastructure.mapper.ProductMapper;
import com.icodeapp.ecommerce.infrastructure.mapper.StockMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Esta clase implementa la interfaz StockRepository y proporciona acceso a los datos de registros de stock en la base de datos.
 */
@Service
public class StockRepositoryImpl implements StockRepository {

    private final StockCrudRepository stockCrudRepository;
    private final StockMapper stockMapper;
    private final ProductMapper productMapper;

    public StockRepositoryImpl(StockCrudRepository stockCrudRepository, StockMapper stockMapper, ProductMapper productMapper) {
        this.stockCrudRepository = stockCrudRepository;
        this.stockMapper = stockMapper;
        this.productMapper = productMapper;
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockMapper.toStock(stockCrudRepository.save(stockMapper.toStockEntity(stock)));
    }

    @Override
    public List<Stock> getStockByProduct(Product product) {
        return stockMapper.toStocks(stockCrudRepository.findByProductEntity(productMapper.toProductEntity(product)));
    }

}
