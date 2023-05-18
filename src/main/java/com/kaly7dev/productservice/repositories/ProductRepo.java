package com.kaly7dev.productservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.kaly7dev.productservice.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends MongoRepository<Product, String> {
}
