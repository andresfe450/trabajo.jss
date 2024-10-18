package com.spring.products.entity;

import java.util.UUID;

public class ProductEntity {

    private UUID id;
    private String name;
    private String category;
    private double price;
    private int stock;

    // Constructor que genera automáticamente el UUID del producto
    public ProductEntity(String name, String category, double price, int stock) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Getters y Setters

    // Devuelve el ID del producto
    public UUID getId() {
        return id;
    }

    // Devuelve el nombre del producto
    public String getName() {
        return name;
    }

    // Establece el nombre del producto
    public void setName(String name) {
        this.name = name;
    }

    // Devuelve la categoría del producto
    public String getCategory() {
        return category;
    }

    // Establece la categoría del producto
    public void setCategory(String category) {
        this.category = category;
    }

    // Devuelve el precio del producto
    public double getPrice() {
        return price;
    }

    // Establece el precio del producto
    public void setPrice(double price) {
        this.price = price;
    }

    // Devuelve el stock disponible del producto
    public int getStock() {
        return stock;
    }

    // Establece el stock disponible del producto
    public void setStock(int stock) {
        this.stock = stock;
    }
}
