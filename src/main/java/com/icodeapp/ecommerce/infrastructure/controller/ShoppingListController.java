package com.icodeapp.ecommerce.infrastructure.controller;

import com.icodeapp.ecommerce.application.service.OrderProductService;
import com.icodeapp.ecommerce.application.service.OrderService;
import com.icodeapp.ecommerce.application.service.UserService;
import com.icodeapp.ecommerce.domain.Order;
import com.icodeapp.ecommerce.domain.OrderProduct;
import com.icodeapp.ecommerce.domain.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/cart/shopping")
@Slf4j
public class ShoppingListController {
    private final OrderService orderService;
    private final UserService userService;
    private final OrderProductService orderProductService;

    public ShoppingListController(OrderService orderService, UserService userService, OrderProductService orderProductService) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderProductService = orderProductService;
    }

    /**
     * Muestra la lista de compras del usuario.
     *
     * @param model       El modelo para agregar atributos a la vista.
     * @param httpSession La sesión HTTP actual.
     * @return La vista que muestra la lista de compras del usuario.
     */
    @GetMapping
    public String showShoppingList(Model model, HttpSession httpSession){
        List<Order> newListOrder = new ArrayList<>();
        User user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));

        Iterable<Order> orders = orderService.getOrdersByuser(user);
        for (Order order: orders ) {
            newListOrder.add(getOrdersProducts(order));
        }
        model.addAttribute("id", Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        model.addAttribute("orders", newListOrder);

        return "user/shoppinglist";
    }

    /**
     * Obtiene los productos de una orden específica.
     *
     * @param order La orden de la cual se obtienen los productos.
     * @return La orden con los productos asociados agregados.
     */
    private Order getOrdersProducts(Order order){
        Iterable<OrderProduct> orderProducts = orderProductService.getOrderProductsByOrder(order);
        order.addOrdersProduct((List<OrderProduct>) orderProducts);
        return order;
    }

}
