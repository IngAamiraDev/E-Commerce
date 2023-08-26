package com.icodeapp.ecommerce.infrastructure.mapper;

import com.icodeapp.ecommerce.domain.Order;
import com.icodeapp.ecommerce.infrastructure.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Interfaz de mapeo para convertir entre Order y OrderEntity.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface OrderMapper {
    /**
     * Convierte una entidad de pedido (OrderEntity) en un objeto de dominio de pedido (Order).
     *
     * @param orderEntity La entidad de pedido a convertir.
     * @return El objeto de dominio de pedido convertido.
     */
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "user", target = "user")
            }
    )
    Order toOrder(OrderEntity orderEntity);

    /**
     * Convierte una lista de entidades de pedido (OrderEntity) en una lista de objetos de dominio de pedido (Order).
     *
     * @param orderEntities La lista de entidades de pedido a convertir.
     * @return La lista de objetos de dominio de pedido convertidos.
     */
    Iterable<Order> toOrders(Iterable<OrderEntity> orderEntities);

    /**
     * Convierte un objeto de dominio de pedido (Order) en una entidad de pedido (OrderEntity).
     *
     * @param order El objeto de dominio de pedido a convertir.
     * @return La entidad de pedido convertida.
     */
    OrderEntity toOrderEntity(Order order);

}
