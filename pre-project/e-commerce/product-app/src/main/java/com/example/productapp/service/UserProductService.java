package com.example.productapp.service;

import com.example.productapp.domain.ProductUser;
import com.example.productapp.domain.Products;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserProductService {
    public ProductUser addUser(ProductUser productUser);
    public ProductUser getUserDetails(String email);
    public ProductUser addProduct(String email, Products products);
    public List<Products> getProducts();
    public  boolean deleteUserById(String email);
    public List<Products> getProduct1(String email);
    public boolean deleteProductById(String id);

    public boolean  deleteProductFromCart(String email,Products products);

}
