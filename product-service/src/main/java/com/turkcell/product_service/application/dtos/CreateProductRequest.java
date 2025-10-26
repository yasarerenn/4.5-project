package com.turkcell.product_service.application.dtos;

import jakarta.validation.constraints.*;

public class CreateProductRequest {
    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    @Size(min = 10)
    private String description;

    @NotNull
    @Positive
    private Double price;

    @NotBlank
    private String currency;

    @NotNull
    @Min(0)
    private Integer stock;

    // Getter ve Setter'lar
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
