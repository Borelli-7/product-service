package com.kaly7dev.productservice.controllers;

import com.kaly7dev.productservice.dtos.ProductRequest;
import com.kaly7dev.productservice.dtos.ProductResponse;
import com.kaly7dev.productservice.entities.Product;
import com.kaly7dev.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController("RestApi")
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductControllerRestImpl implements ProductController {

    private final ProductService productService;
    @Override
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
       return productService.createProduct(productRequest);
    }
    @Override
    @GetMapping("/lists")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> productList() {
        return productService.getProductList();
    }
    @Override
    @PutMapping("/update/{productId}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ProductResponse updateProduct(@PathVariable String productId, @RequestBody ProductRequest productRequest) {
         return productService.updateProduct(productId, productRequest);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionhandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
