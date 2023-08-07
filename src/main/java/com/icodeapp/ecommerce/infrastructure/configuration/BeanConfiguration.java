package com.icodeapp.ecommerce.infrastructure.configuration;

import com.icodeapp.ecommerce.application.repository.ProductRepository;
import com.icodeapp.ecommerce.application.repository.StockRepository;
import com.icodeapp.ecommerce.application.service.ProductService;
import com.icodeapp.ecommerce.application.service.StockService;
import com.icodeapp.ecommerce.application.service.UploadFile;
import com.icodeapp.ecommerce.application.service.ValidateStock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile){
        return new ProductService(productRepository, uploadFile);
    }
    @Bean
    public UploadFile uploadFile(){
        return new UploadFile();
    }

    @Bean
    public StockService stockService(StockRepository stockRepository){
        return new StockService(stockRepository);
    }
    @Bean
    public ValidateStock validateStock(StockService stockService){
        return new ValidateStock(stockService);
    }

}
