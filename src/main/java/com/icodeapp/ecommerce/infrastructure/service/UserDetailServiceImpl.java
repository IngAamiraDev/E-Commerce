package com.icodeapp.ecommerce.infrastructure.service;

import com.icodeapp.ecommerce.application.service.LoginService;
import com.icodeapp.ecommerce.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementación de UserDetailsService para cargar detalles de usuario durante la autenticación.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final LoginService loginService;
    private final Integer USER_NOT_FOUND = 0;

    @Autowired
    private HttpSession httpSession;

    /**
     * Constructor de UserDetailServiceImpl.
     *
     * @param loginService El servicio de inicio de sesión.
     */
    public UserDetailServiceImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Carga los detalles del usuario según su nombre de usuario durante la autenticación.
     *
     * @param username El nombre de usuario del usuario a autenticar.
     * @return Los detalles del usuario autenticado.
     * @throws UsernameNotFoundException Si el usuario no se encuentra.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Integer idUser = loginService.getUserId(username);
        if (idUser != USER_NOT_FOUND){
            User user = loginService.getuser(username);
            httpSession.setAttribute("iduser", user.getId());

            // Construir y devolver los detalles del usuario para la autenticación
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getUserType().name())
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

}
