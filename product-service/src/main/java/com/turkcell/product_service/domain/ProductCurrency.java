package com.turkcell.product_service.domain;

import java.util.Objects;

public class ProductCurrency {
    public enum CurrencyType {
        TRY, USD, EUR
    }

    private final CurrencyType value;

    public ProductCurrency(CurrencyType value) {
        if (value == null)
            throw new IllegalArgumentException("Currency cannot be null");
        this.value = value;
    }

    public CurrencyType getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ProductCurrency))
            return false;
        ProductCurrency that = (ProductCurrency) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.name();
    }
}
