package com.icodeapp.ecommerce.infrastructure.controller;

import com.icodeapp.ecommerce.application.service.LoginService;
import com.icodeapp.ecommerce.domain.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador para gestionar el proceso de inicio de sesión y redireccionar según el tipo de usuario.
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Maneja la solicitud para mostrar la página de inicio de sesión.
     *
     * @return La vista de inicio de sesión.
     */
    @GetMapping
    public String login(){
        return "login";
    }

    /**
     * Maneja la solicitud de redirección después del inicio de sesión.
     *
     * @param attributes  Atributos para el redireccionamiento.
     * @param httpSession La sesión HTTP del usuario.
     * @return La vista a la que se debe redirigir según el tipo de usuario.
     */
    @GetMapping("/access")
    public String access(RedirectAttributes attributes, HttpSession httpSession){
        User user = loginService.getUser( Integer.parseInt( httpSession.getAttribute("iduser").toString() ) ) ;
        attributes.addFlashAttribute("id", httpSession.getAttribute("iduser").toString() );
        if(loginService.existUser(user.getEmail())){
            if (loginService.getUserType(user.getEmail()).name().equals("ADMIN")){
                return "redirect:/admin";
            } else {
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }

}
