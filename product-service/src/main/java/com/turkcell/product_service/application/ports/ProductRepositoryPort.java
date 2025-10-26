package com.turkcell.product_service.application.ports;

import com.turkcell.product_service.domain.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    Product save(Product product);

    Optional<Product> findById(UUID id);

    List<Product> findAll();

    Product update(Product product);

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
