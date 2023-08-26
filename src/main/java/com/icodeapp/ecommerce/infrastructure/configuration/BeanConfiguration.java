package com.icodeapp.ecommerce.infrastructure.configuration;

import com.icodeapp.ecommerce.application.repository.*;
import com.icodeapp.ecommerce.application.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;

/**
 * Esta clase de configuración define y configura los beans utilizados en la aplicación.
 */
@Configuration
public class BeanConfiguration {

    /**
     * Define un bean para el servicio de productos.
     *
     * @param productRepository El repositorio de productos.
     * @param uploadFile El servicio de carga de archivos.
     * @return El servicio de productos configurado.
     */
    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile){
        return new ProductService(productRepository, uploadFile);
    }

    // Define otros beans aquí para otros servicios y componentes

    // ...

    /**
     * Define un bean para el servicio de registro de usuarios.
     *
     * @param userService El servicio de usuarios.
     * @param passwordEncoder El codificador de contraseñas.
     * @return El servicio de registro de usuarios configurado.
     */
    @Bean
    public RegistrationService registrationService(UserService userService, PasswordEncoder passwordEncoder){
        return  new RegistrationService(userService, passwordEncoder);
    }

    /**
     * Define un bean para el servicio de inicio de sesión.
     *
     * @param userService El servicio de usuarios.
     * @return El servicio de inicio de sesión configurado.
     */
    @Bean
    public LoginService loginService(UserService userService){
        return new LoginService(userService);
    }

    /**
     * Define un bean para el servicio de cierre de sesión.
     *
     * @return El servicio de cierre de sesión configurado.
     */
    @Bean
    public LogoutService logoutService(){
        return  new LogoutService();
    }

}
