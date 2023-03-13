package com.example.productapp.service;

import com.example.productapp.domain.Products;

import java.util.List;

public interface ProductService {
    public abstract List<Products> getAllProducts();
    public abstract Products addProduct(Products products);
    public abstract Products getProductById(String productId);
    public abstract boolean deleteProduct(String productId);
}
