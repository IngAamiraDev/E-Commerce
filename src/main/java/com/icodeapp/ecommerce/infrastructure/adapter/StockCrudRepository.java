package com.icodeapp.ecommerce.infrastructure.adapter;

import com.icodeapp.ecommerce.infrastructure.entity.ProductEntity;
import com.icodeapp.ecommerce.infrastructure.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Esta interfaz proporciona métodos para acceder a los datos de registros de stock en la base de datos.
 */
public interface StockCrudRepository extends CrudRepository<StockEntity, Integer> {

    /**
     * Busca y devuelve una lista de registros de stock asociados a un producto específico.
     *
     * @param productEntity El producto para el cual se desean buscar los registros de stock.
     * @return Una lista de registros de stock asociados al producto dado.
     */
    List<StockEntity> findByProductEntity(ProductEntity productEntity);

}
