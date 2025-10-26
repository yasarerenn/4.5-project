package com.turkcell.product_service.domain;

import java.util.Objects;

public class ProductStock {
    private final int value;

    public ProductStock(int value) {
        if (value < 0)
            throw new IllegalArgumentException("Stok negatif olamaz");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ProductStock))
            return false;
        ProductStock that = (ProductStock) o;
        return value == that.value;
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
