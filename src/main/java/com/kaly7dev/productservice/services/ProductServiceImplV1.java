package com.kaly7dev.productservice.services;

import com.kaly7dev.productservice.dtos.ProductRequest;
import com.kaly7dev.productservice.dtos.ProductResponse;
import com.kaly7dev.productservice.entities.Product;
import com.kaly7dev.productservice.exception.ProductNotFoundException;
import com.kaly7dev.productservice.repositories.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public final class ProductServiceImplV1 implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImplV1(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName(productRequest.getProductName())
                .productDesc(productRequest.getProductDesc())
                .productPrice(productRequest.getProductPrice())
                .build();

        log.info("product created");
        return mapToDto( productRepo.save(product));
    }

    @Override
    public List<ProductResponse> getProductList() {
        List<Product> productList= productRepo.findAll();
        return productList.stream().map(this::mapToDto
        ).toList();
    }

    @Override
    public ProductResponse updateProduct(String productId, ProductRequest productRequest) {
         productRepo.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException(
                        String.format("Product Id: %s not found", productId))
        );

        log.info("Product with id: {} updated", productId);
        return mapToDto(
                productRepo.save(
                        mapToEntity(
                                productId,
                                productRequest)));
    }

    private Product mapToEntity(String productId, ProductRequest productRequest) {
        return Product.builder()
                .productId(productId)
                .productName(productRequest.getProductName())
                .productDesc(productRequest.getProductDesc())
                .productPrice(productRequest.getProductPrice())
                .build();
    }

    private ProductResponse mapToDto(Product product) {
      return   ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productDesc(product.getProductDesc())
                .productPrice(product.getProductPrice())
                .build();
    }
}
