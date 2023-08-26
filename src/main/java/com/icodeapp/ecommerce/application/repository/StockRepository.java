package com.icodeapp.ecommerce.application.repository;

import com.icodeapp.ecommerce.domain.Product;
import com.icodeapp.ecommerce.domain.Stock;

import java.util.List;

/**
 * Esta interfaz define las operaciones para acceder al inventario (stock) en el repositorio.
 */
public interface StockRepository {

    /**
     * Guarda un registro de inventario en el repositorio.
     *
     * @param stock El registro de inventario a guardar.
     * @return El registro de inventario guardado.
     */
    Stock saveStock(Stock stock);

    /**
     * Obtiene una lista de registros de inventario asociados a un producto específico.
     *
     * @param product El producto para el cual se quieren obtener los registros de inventario.
     * @return Una lista de registros de inventario asociados al producto dado.
     */
    List<Stock> getStockByProduct(Product product);
}
