package com.spring.products.controller;

import com.spring.products.entity.ProductEntity;
import com.spring.products.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        ProductEntity createdProduct = productService.createProduct(
            product.getName(),
            product.getCategory(),
            product.getPrice(),
            product.getStock()
        );
        return ResponseEntity.ok(createdProduct);
    }

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable UUID id) {
        Optional<ProductEntity> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar producto por ID
    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(
        @PathVariable UUID id,
        @RequestBody ProductEntity productDetails
    ) {
        Optional<ProductEntity> updatedProduct = productService.updateProduct(
            id,
            productDetails.getName(),
            productDetails.getCategory(),
            productDetails.getPrice(),
            productDetails.getStock()
        );
        return updatedProduct.map(ResponseEntity::ok)
                             .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        boolean deleted = productService.deleteProduct(id);
        return deleted ? ResponseEntity.noContent().build() 
                       : ResponseEntity.notFound().build();
    }
}
