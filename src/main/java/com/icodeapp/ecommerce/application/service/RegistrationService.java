package com.icodeapp.ecommerce.application.service;

import com.icodeapp.ecommerce.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Esta clase proporciona métodos para manejar el proceso de registro de usuarios en la aplicación.
 */
public class RegistrationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor de la clase RegistrationService.
     *
     * @param userService     El servicio de usuarios utilizado para acceder a los datos de usuarios.
     * @param passwordEncoder El codificador de contraseñas utilizado para cifrar las contraseñas de los usuarios.
     */
    public RegistrationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registra a un nuevo usuario en la aplicación.
     *
     * @param user El usuario a registrar.
     */
    public void register(User user) {
        // Cifrar la contraseña antes de almacenarla en la base de datos.
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
    }

}
