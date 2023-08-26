package com.icodeapp.ecommerce.application.service;

import com.icodeapp.ecommerce.domain.User;
import com.icodeapp.ecommerce.domain.UserType;

/**
 * Esta clase proporciona métodos para manejar el inicio de sesión y obtener información sobre los usuarios.
 */
public class LoginService {

    private final UserService userService;

    /**
     * Constructor de la clase LoginService.
     *
     * @param userService El servicio de usuarios utilizado para acceder a la información de los usuarios.
     */
    public LoginService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Verifica si existe un usuario con el correo electrónico dado.
     *
     * @param email El correo electrónico del usuario a verificar.
     * @return `true` si el usuario existe, `false` si no.
     */
    public boolean existUser(String email) {
        try {
            User user = userService.findByEmail(email);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Obtiene el ID del usuario asociado al correo electrónico.
     *
     * @param email El correo electrónico del usuario.
     * @return El ID del usuario o 0 si no se encuentra.
     */
    public Integer getUserId(String email) {
        try {
            return userService.findByEmail(email).getId();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Obtiene el tipo de usuario asociado al correo electrónico.
     *
     * @param email El correo electrónico del usuario.
     * @return El tipo de usuario o null si no se encuentra.
     */
    public UserType getUserType(String email) {
        return userService.findByEmail(email).getUserType();
    }

    /**
     * Obtiene un objeto User asociado al correo electrónico.
     *
     * @param email El correo electrónico del usuario.
     * @return El objeto User o un nuevo objeto User si no se encuentra.
     */
    public User getUser(String email) {
        try {
            return userService.findByEmail(email);
        } catch (Exception e) {
            return new User();
        }
    }

    /**
     * Obtiene un objeto User asociado al ID del usuario.
     *
     * @param id El ID del usuario.
     * @return El objeto User o un nuevo objeto User si no se encuentra.
     */
    public User getUser(Integer id) {
        try {
            return userService.findById(id);
        } catch (Exception e) {
            return new User();
        }
    }

    public User getuser(String username) {
        return null;
    }
}
