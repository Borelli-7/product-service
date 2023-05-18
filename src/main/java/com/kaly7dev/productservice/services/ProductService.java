package com.kaly7dev.productservice.services;

import com.kaly7dev.productservice.dtos.ProductRequest;
import com.kaly7dev.productservice.dtos.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    List<ProductResponse> getProductList();

    ProductResponse updateProduct(String productId, ProductRequest productRequest);
    // void updateProduct(String productId, ProductRequest productRequest);
}
