package com.springmicroservices.productservice.repository;

import com.springmicroservices.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProducyRepository extends MongoRepository<Product, String> {
}
