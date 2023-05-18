package com.kaly7dev.productservice.controllers;

import com.kaly7dev.productservice.dtos.ProductRequest;
import com.kaly7dev.productservice.dtos.ProductResponse;
import com.kaly7dev.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

//Controller("GraphQl")
@RequiredArgsConstructor
public class ProductControllerGraphQLImpl implements ProductController {
    private final ProductService productService;
    @Override
    @MutationMapping
    public ProductResponse createProduct(@Argument ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @Override
    @QueryMapping
    public List<ProductResponse> productList() {
        return productService.getProductList();
    }

    @Override
    @MutationMapping
    public ProductResponse updateProduct(@Argument String productId,
                                         @Argument ProductRequest productRequest) {
        return productService.updateProduct(productId, productRequest);
    }
}
