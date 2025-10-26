package com.turkcell.product_service.infrastructure.mappers;

import com.turkcell.product_service.domain.*;
import com.turkcell.product_service.infrastructure.entities.ProductEntity;

public class ProductMapper {
    public static ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId().getValue());
        entity.setName(product.getName().getValue());
        entity.setDescription(product.getDescription().getValue());
        entity.setPrice(product.getPrice().getValue());
        entity.setCurrency(product.getCurrency().getValue().name());
        entity.setStock(product.getStock().getValue());
        return entity;
    }

    public static Product toDomain(ProductEntity entity) {
        return new Product(
                new ProductId(entity.getId()),
                new ProductName(entity.getName()),
                new ProductDescription(entity.getDescription()),
                new ProductPrice(entity.getPrice()),
                new ProductCurrency(ProductCurrency.CurrencyType.valueOf(entity.getCurrency())),
                new ProductStock(entity.getStock()));
    }
}
