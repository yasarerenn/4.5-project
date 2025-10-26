package com.turkcell.product_service.application.usecases;

import com.turkcell.product_service.application.ports.ProductRepositoryPort;
import com.turkcell.product_service.application.dtos.*;
import com.turkcell.product_service.domain.*;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class GetProductByIdUseCase {
    private final ProductRepositoryPort repository;

    public GetProductByIdUseCase(ProductRepositoryPort repository) {
        this.repository = repository;
    }

    public ProductResponse handle(UUID id) {
        Product product = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ürün bulunamadı"));
        ProductResponse resp = new ProductResponse();
        resp.setId(product.getId().getValue());
        resp.setName(product.getName().getValue());
        resp.setDescription(product.getDescription().getValue());
        resp.setPrice(product.getPrice().getValue());
        resp.setCurrency(product.getCurrency().getValue().name());
        resp.setStock(product.getStock().getValue());
        return resp;
    }
}
