package com.example.productapp.repository;

import com.example.productapp.domain.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Products,String> {
}
