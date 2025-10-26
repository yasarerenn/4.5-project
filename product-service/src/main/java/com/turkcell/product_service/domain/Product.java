package com.turkcell.product_service.domain;

import java.util.Objects;

// Product Aggregate Root - Entity
public class Product {
    private final ProductId id;
    private final ProductName name;
    private final ProductDescription description;
    private final ProductPrice price;
    private final ProductCurrency currency;
    private final ProductStock stock;

    public Product(ProductId id, ProductName name, ProductDescription description, ProductPrice price,
            ProductCurrency currency, ProductStock stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.stock = stock;
    }

    public ProductId getId() {
        return id;
    }

    public ProductName getName() {
        return name;
    }

    public ProductDescription getDescription() {
        return description;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public ProductCurrency getCurrency() {
        return currency;
    }

    public ProductStock getStock() {
        return stock;
    }

    // Diğer iş kuralları burada yazılabilir

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Product product = (Product) obj;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
