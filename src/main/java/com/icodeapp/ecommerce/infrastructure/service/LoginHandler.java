package com.icodeapp.ecommerce.infrastructure.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Handler para el éxito de autenticación que redirige a diferentes páginas según el rol del usuario.
 */
@Component
public class LoginHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    /**
     * Maneja el éxito de la autenticación y redirige a la página correspondiente al rol del usuario.
     *
     * @param request        La solicitud HTTP recibida.
     * @param response       La respuesta HTTP para redirigir.
     * @param authentication La información de autenticación.
     * @throws ServletException Si ocurre un error durante el manejo de la solicitud.
     * @throws IOException      Si ocurre un error durante la redirección.
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        // Código de manejo de autenticación
    }

}
