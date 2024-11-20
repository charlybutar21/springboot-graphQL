package com.charly.springbootgraphql.dto;

import lombok.Data;

@Data
public class ProductInput {
    private String name;
    private String description;
    private Double price;
}
