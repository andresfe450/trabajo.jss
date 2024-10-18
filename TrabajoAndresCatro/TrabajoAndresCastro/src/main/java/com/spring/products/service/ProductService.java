package com.spring.products.service;

import com.spring.products.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final List<ProductEntity> productList = new ArrayList<>();

    // Constructor con datos iniciales
    public ProductService() {
        productList.add(new ProductEntity("Laptop", "Electrónica", 1000.00, 50));
        productList.add(new ProductEntity("Silla", "Muebles", 150.00, 30));
        productList.add(new ProductEntity("Cámara", "Fotografía", 500.00, 15));
    }
    
    // Crear un nuevo producto
    public ProductEntity createProduct(String name, String category, double price, int stock) {
        ProductEntity newProduct = new ProductEntity(name, category, price, stock);
        productList.add(newProduct);
        return newProduct;
    }

    // Obtener todos los productos
    public List<ProductEntity> getAllProducts() {
        return productList;
    }

    // Obtener un producto por su ID
    public Optional<ProductEntity> getProductById(UUID id) {
        return productList.stream()
                          .filter(product -> product.getId().equals(id))
                          .findFirst();
    }

    // Actualizar un producto por su ID
    public Optional<ProductEntity> updateProduct(UUID id, String name, String category, double price, int stock) {
        Optional<ProductEntity> productOpt = getProductById(id);
        if (productOpt.isPresent()) {
            ProductEntity product = productOpt.get();
            product.setName(name);
            product.setCategory(category);
            product.setPrice(price);
            product.setStock(stock);
            return Optional.of(product);
        }
        return Optional.empty();
    }

    // Eliminar un producto por su ID
    public boolean deleteProduct(UUID id) {
        return productList.removeIf(product -> product.getId().equals(id));
    }
}
