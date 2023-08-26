package com.icodeapp.ecommerce.infrastructure.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entidad que representa la relación entre una orden y un producto en la base de datos.
 */
@Data
@Entity
@Table(name = "ordersproducts")
public class OrderProductEntity {

    /**
     * Clave primaria embebida que combina la clave de la orden y la clave del producto.
     */
    @EmbeddedId
    private OrderProductPK pk;

    /**
     * La cantidad del producto en la orden.
     */
    private Integer quantity;

    // Resto de los atributos, constructores y métodos si los hubiera.

}
