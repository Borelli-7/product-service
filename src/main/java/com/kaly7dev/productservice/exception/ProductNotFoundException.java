package com.kaly7dev.productservice.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String format) {
        super(format);
    }
}
