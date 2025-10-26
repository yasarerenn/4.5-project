package com.turkcell.product_service.domain;

import java.util.Objects;
import java.util.UUID;

// ProductId Value Object - Tekilleştirme
public class ProductId {
    private final UUID value;

    public ProductId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    public static ProductId newId() {
        return new ProductId(UUID.randomUUID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductId)) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(value, productId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
