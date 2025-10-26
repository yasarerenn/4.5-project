package com.turkcell.product_service.infrastructure.repositories;

import com.turkcell.product_service.application.ports.ProductRepositoryPort;
import com.turkcell.product_service.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryPort {
    private final Map<UUID, Product> productStore = new ConcurrentHashMap<>();

    @Override
    public Product save(Product product) {
        productStore.put(product.getId().getValue(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return Optional.ofNullable(productStore.get(id));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productStore.values());
    }

    @Override
    public Product update(Product product) {
        productStore.put(product.getId().getValue(), product);
        return product;
    }

    @Override
    public void deleteById(UUID id) {
        productStore.remove(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return productStore.containsKey(id);
    }
}
