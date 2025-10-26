package com.turkcell.product_service.application.dtos;

import jakarta.validation.constraints.*;

public class UpdateProductRequest {
    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    @Size(min = 10)
    private String description;

    // Getter ve Setter'lar
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
