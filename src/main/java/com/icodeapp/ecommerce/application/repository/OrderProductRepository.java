package com.icodeapp.ecommerce.application.repository;

import com.icodeapp.ecommerce.domain.Order;
import com.icodeapp.ecommerce.domain.OrderProduct;

import java.util.List;

/**
 * Esta interfaz define las operaciones para acceder a los productos de una orden en el repositorio.
 */
public interface OrderProductRepository {

    /**
     * Crea un nuevo registro de producto de orden en el repositorio.
     *
     * @param orderProduct El producto de orden a crear.
     * @return El producto de orden creado.
     */
    OrderProduct create(OrderProduct orderProduct);

    /**
     * Obtiene todos los productos de orden en el repositorio.
     *
     * @return Una colección de productos de orden.
     */
    Iterable<OrderProduct> getOrderProducts();

    /**
     * Obtiene una lista de productos de orden asociados a una orden específica.
     *
     * @param order La orden para la cual se quieren obtener los productos de orden.
     * @return Una lista de productos de orden asociados a la orden dada.
     */
    List<OrderProduct> getOrdersProductByOrder(Order order);

}
