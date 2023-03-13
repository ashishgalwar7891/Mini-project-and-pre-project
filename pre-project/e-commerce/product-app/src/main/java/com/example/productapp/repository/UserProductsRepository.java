package com.example.productapp.repository;

import com.example.productapp.domain.ProductUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserProductsRepository extends MongoRepository<ProductUser,String> {
//    @Query("{'products.productId':{$eq:[?0]}}")
//    public ProductUser deleteProductFromCart(String pid);
}
