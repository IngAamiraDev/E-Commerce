package com.icodeapp.ecommerce.application.service;

import com.icodeapp.ecommerce.application.repository.OrderProductRepository;
import com.icodeapp.ecommerce.domain.Order;
import com.icodeapp.ecommerce.domain.OrderProduct;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Esta clase proporciona métodos para manejar los productos de una orden en la aplicación.
 */
@Service
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    /**
     * Constructor de la clase OrderProductService.
     *
     * @param orderProductRepository El repositorio de productos de orden utilizado para acceder a los datos.
     */
    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    /**
     * Crea un nuevo producto de orden.
     *
     * @param orderProduct El producto de orden a crear.
     * @return El producto de orden creado.
     */
    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductRepository.create(orderProduct);
    }

    /**
     * Obtiene todos los productos de orden almacenados.
     *
     * @return Una colección de productos de orden.
     */
    public Iterable<OrderProduct> getOrderProduct() {
        return orderProductRepository.getOrderProducts();
    }

    /**
     * Obtiene una lista de productos de orden asociados a una orden específica.
     *
     * @param order La orden para la cual se quieren obtener los productos de orden.
     * @return Una lista de productos de orden asociados a la orden dada.
     */
    public List<OrderProduct> getOrderProductsByOrder(Order order) {
        return orderProductRepository.getOrdersProductByOrder(order);
    }

}
