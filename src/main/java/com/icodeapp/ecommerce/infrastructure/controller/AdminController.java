package com.icodeapp.ecommerce.infrastructure.controller;

import com.icodeapp.ecommerce.application.service.ProductService;
import com.icodeapp.ecommerce.domain.Product;
import com.icodeapp.ecommerce.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para las funciones de administración.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Maneja la solicitud para la página de inicio del panel de administración.
     *
     * @param model El modelo para la vista.
     * @return La vista de la página de inicio del panel de administración.
     */
    @GetMapping
    public String home(Model model){
        User user = new User();
        user.setId(1);
        Iterable<Product> products = productService.getProductsByUser(user);
        model.addAttribute("products", products);
        return "admin/home";
    }

}
