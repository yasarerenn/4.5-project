package com.turkcell.product_service.application.usecases;

import com.turkcell.product_service.application.ports.ProductRepositoryPort;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class DeleteProductUseCase {
    private final ProductRepositoryPort repository;

    public DeleteProductUseCase(ProductRepositoryPort repository) {
        this.repository = repository;
    }

    public void handle(UUID id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Ürün bulunamadı");
        }
        repository.deleteById(id);
    }
}
