package com.turkcell.product_service.application.usecases;

import com.turkcell.product_service.application.ports.ProductRepositoryPort;
import com.turkcell.product_service.application.dtos.*;
import com.turkcell.product_service.domain.*;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {
    private final ProductRepositoryPort repository;

    public CreateProductUseCase(ProductRepositoryPort repository) {
        this.repository = repository;
    }

    public ProductResponse handle(CreateProductRequest req) {
        Product product = new Product(
                ProductId.newId(),
                new ProductName(req.getName()),
                new ProductDescription(req.getDescription()),
                new ProductPrice(req.getPrice()),
                new ProductCurrency(ProductCurrency.CurrencyType.valueOf(req.getCurrency())),
                new ProductStock(req.getStock()));
        Product saved = repository.save(product);
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
