package com.icodeapp.ecommerce.application.service;

import com.icodeapp.ecommerce.application.repository.ProductRepository;
import com.icodeapp.ecommerce.domain.Product;
import com.icodeapp.ecommerce.domain.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Esta clase proporciona métodos para manejar los productos en la aplicación.
 */
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final UploadFile uploadFile;

    /**
     * Constructor de la clase ProductService.
     *
     * @param productRepository El repositorio de productos utilizado para acceder a los datos de los productos.
     * @param uploadFile       La clase que se encarga de subir y eliminar archivos.
     */
    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    /**
     * Obtiene todos los productos almacenados.
     *
     * @return Una colección de productos.
     */
    public Iterable<Product> getProducts() {
        return productRepository.getProducts();
    }

    /**
     * Obtiene todos los productos asociados a un usuario específico.
     *
     * @param user El usuario para el cual se quieren obtener los productos.
     * @return Una colección de productos asociados al usuario dado.
     */
    public Iterable<Product> getProductsByUser(User user) {
        return productRepository.getProductsByUser(user);
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param id El ID del producto a obtener.
     * @return El producto correspondiente al ID dado, o null si no se encuentra.
     */
    public Product getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    /**
     * Guarda un producto en el repositorio.
     *
     * @param product       El producto a guardar.
     * @param multipartFile El archivo multimedia asociado al producto.
     * @param httpSession   La sesión HTTP del usuario.
     * @return El producto guardado.
     * @throws IOException Si ocurre un error al manipular el archivo.
     */
    public Product saveProduct(Product product, MultipartFile multipartFile, HttpSession httpSession) throws IOException {
        // El resto del código de este método se ha omitido para brevedad.
        return product;
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param id El ID del producto a eliminar.
     */
    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }

}
