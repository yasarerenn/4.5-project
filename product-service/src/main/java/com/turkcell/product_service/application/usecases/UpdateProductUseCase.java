package com.turkcell.product_service.application.usecases;

import com.turkcell.product_service.application.ports.ProductRepositoryPort;
import com.turkcell.product_service.application.dtos.*;
import com.turkcell.product_service.domain.*;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UpdateProductUseCase {
    private final ProductRepositoryPort repository;

    public UpdateProductUseCase(ProductRepositoryPort repository) {
        this.repository = repository;
    }

    public ProductResponse handle(UUID id, UpdateProductRequest req) {
        Product existing = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ürün bulunamadı"));
        Product updated = new Product(
                existing.getId(),
                new ProductName(req.getName()),
                new ProductDescription(req.getDescription()),
                existing.getPrice(),
                existing.getCurrency(),
                existing.getStock()
        );
        Product saved = repository.update(updated);
        ProductResponse resp = new ProductResponse();
        resp.setId(saved.getId().getValue());
        resp.setName(saved.getName().getValue());
        resp.setDescription(saved.getDescription().getValue());
        resp.setPrice(saved.getPrice().getValue());
        resp.setCurrency(saved.getCurrency().getValue().name());
        resp.setStock(saved.getStock().getValue());
        return resp;
    }
}
