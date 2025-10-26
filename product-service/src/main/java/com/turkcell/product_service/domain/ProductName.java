package com.turkcell.product_service.domain;

import java.util.Objects;

public class ProductName {
    private final String value;

    public ProductName(String value) {
        if (value == null || value.trim().length() < 2)
            throw new IllegalArgumentException("Product name must be at least 2 characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductName)) return false;
        ProductName that = (ProductName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
