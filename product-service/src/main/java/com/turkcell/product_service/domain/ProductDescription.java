package com.turkcell.product_service.domain;

import java.util.Objects;

public class ProductDescription {
    private final String value;

    public ProductDescription(String value) {
        if (value == null || value.trim().length() < 5)
            throw new IllegalArgumentException("Product Description must be at least 5 characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDescription)) return false;
        ProductDescription that = (ProductDescription) o;
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
