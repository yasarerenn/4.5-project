package com.turkcell.product_service.application.usecases;

import com.turkcell.product_service.application.ports.ProductRepositoryPort;
import com.turkcell.product_service.application.dtos.ProductListResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllProductsUseCase {
    private final ProductRepositoryPort repository;

    public GetAllProductsUseCase(ProductRepositoryPort repository) {
        this.repository = repository;
    }

    public List<ProductListResponse> handle() {
        return repository.findAll().stream().map(product -> {
            ProductListResponse resp = new ProductListResponse();
            resp.setId(product.getId().getValue());
            resp.setName(product.getName().getValue());
            resp.setDescription(product.getDescription().getValue());
            resp.setPrice(product.getPrice().getValue());
            resp.setCurrency(product.getCurrency().getValue().name());
            resp.setStock(product.getStock().getValue());
            return resp;
        }).collect(Collectors.toList());
    }
}
