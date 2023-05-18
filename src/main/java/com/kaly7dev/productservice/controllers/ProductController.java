package com.kaly7dev.productservice.controllers;

import com.kaly7dev.productservice.dtos.ProductRequest;
import com.kaly7dev.productservice.dtos.ProductResponse;

import java.util.List;
public interface ProductController {

    ProductResponse createProduct(ProductRequest productRequest);
    List<ProductResponse> productList();
    ProductResponse updateProduct(String productId, ProductRequest productRequest);
}
