package com.kaly7dev.productservice.services;

import com.kaly7dev.productservice.dtos.ProductRequest;
import com.kaly7dev.productservice.dtos.ProductResponse;
import com.kaly7dev.productservice.repositories.ProductRepo;
import com.kaly7dev.productservice.entities.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplV1Test {
    @MockBean
    private static ProductRepo productRepo;
    @Autowired
    private static ProductService productService;

    @BeforeAll
    public static void setUp(){
        productService= new ProductServiceImplV1(productRepo);
    }

    @Test
    @DisplayName("Should create product")
    void createProduct() {
/*        ProductResponse expectedResponse = new ProductResponse(
                "azerty","iphone","mobile phone", BigDecimal.valueOf(234));
        Product product = new Product(
                "azerty","iphone","mobile phone", BigDecimal.valueOf(234));
        ProductRequest productRequest= new ProductRequest(
                "iphone", "mobile phone",BigDecimal.valueOf(234));

        ProductResponse actualResponse = productService.createProduct(productRequest);
        Mockito.verify(productRepo,Mockito.times(1)).save(product);

        Assertions.assertThat(actualResponse.getProductName()).isEqualTo(expectedResponse.getProductName());*/
    }

    @Test
    void getProductList() {
    }
}