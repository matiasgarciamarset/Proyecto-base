package com.matias.api.dto;

public class ProductDto {
    private String id;
    private String name;

    public ProductDto(int id, String name) {
        this.id = String.valueOf(id);
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
