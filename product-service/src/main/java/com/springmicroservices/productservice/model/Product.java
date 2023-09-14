package com.springmicroservices.productservice.model;

import io.micrometer.observation.ObservationFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    public static Product product;
    @Id
    private String id;
    private String name;
    private String description;
    private Double price;

}
