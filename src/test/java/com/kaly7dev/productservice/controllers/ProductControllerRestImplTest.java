package com.kaly7dev.productservice.controllers;

import com.kaly7dev.productservice.dtos.ProductResponse;
import com.kaly7dev.productservice.services.ProductService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductControllerRestImpl.class)
class ProductControllerRestImplTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ProductService productService;

    @Test
    @DisplayName("Should List all products when making get request to endpoint - /api/product/lists ")
    void createProduct() throws Exception {
        ProductResponse productResponse1= new ProductResponse(
                "azerty","iphone","mobile phone", BigDecimal.valueOf(23000));
        ProductResponse productResponse2= new ProductResponse(
                "querty","samsung","mobile phone", BigDecimal.valueOf(450));

        Mockito.when(productService.getProductList()).thenReturn(asList(productResponse1, productResponse2));

        mvc.perform(get("/api/product/lists"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.size()", Matchers.is(2)))
                .andExpect(jsonPath("$[0].productId", Matchers.is("azerty")))
                .andExpect(jsonPath("$[0].productName", Matchers.is("iphone")))
                .andExpect(jsonPath("$[1].productId", Matchers.is("querty")))
                .andExpect(jsonPath("$[1].productName", Matchers.is("samsung")));

    }
}