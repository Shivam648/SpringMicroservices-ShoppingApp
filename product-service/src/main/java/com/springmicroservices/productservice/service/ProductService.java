package com.springmicroservices.productservice.service;

import com.springmicroservices.productservice.dto.ProductResponse;
import com.springmicroservices.productservice.dto.ProducyRequest;
import com.springmicroservices.productservice.model.Product;
import com.springmicroservices.productservice.repository.ProducyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.springmicroservices.productservice.model.Product.product;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProducyRepository producyRepository;

//    public ProductService(ProducyRepository producyRepository) {
//        this.producyRepository = producyRepository;
//    }

    public void createProduct(ProducyRequest productRequest) {
        product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        producyRepository.save(product);
        log.info("Product created successfully {}", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = producyRepository.findAll();
        
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
