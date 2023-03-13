package com.example.productapp.service;

import com.example.productapp.domain.Products;
import com.example.productapp.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductsRepository productsRepository;
    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products addProduct(Products products) {
        return productsRepository.insert(products);
    }

    @Override
    public Products getProductById(String productId) {
        return productsRepository.findById(productId).get();
    }

    @Override
    public boolean deleteProduct(String productId) {
        productsRepository.deleteById(productId);
        return true;
    }

}
