package com.icodeapp.ecommerce.infrastructure.controller;

import com.icodeapp.ecommerce.application.service.LogoutService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para manejar la funcionalidad de cierre de sesión de un usuario.
 */
@Controller
@RequestMapping("/close")
public class LogoutController {

    private final LogoutService logoutService;

    public LogoutController(LogoutService logoutService) {
        this.logoutService = logoutService;
    }

    /**
     * Maneja la solicitud de cierre de sesión y redirige al usuario a la página de inicio.
     *
     * @param httpSession La sesión HTTP del usuario.
     * @return Redirige a la página de inicio después del cierre de sesión.
     */
    @GetMapping
    public String logout(HttpSession httpSession){
        logoutService.logout(httpSession);
        return "redirect:/home";
    }

}
