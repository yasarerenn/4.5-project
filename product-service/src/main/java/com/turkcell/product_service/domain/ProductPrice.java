package com.turkcell.product_service.domain;

import java.util.Objects;

public class ProductPrice {
    private final double value;

    public ProductPrice(double value) {
        if (value <= 0) throw new IllegalArgumentException("Product price must be positive");
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductPrice)) return false;
        ProductPrice that = (ProductPrice) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
