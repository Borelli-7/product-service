package com.kaly7dev.productservice.repositories;

import com.kaly7dev.productservice.entities.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class ProductRepoTest {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ProductRepo productRepo;

    @Test
    @DisplayName("Should save product")
    void shouldSaveProduct(){
        Product expectedProduct = new Product(
                null,"iphone","mobile phone", BigDecimal.valueOf(12000));
        Product actualProduct = productRepo.save(expectedProduct);
        assertThat(actualProduct).usingRecursiveComparison().ignoringFields("productId")
                .isEqualTo(expectedProduct);
    }

}