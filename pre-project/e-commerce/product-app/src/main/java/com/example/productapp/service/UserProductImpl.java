package com.example.productapp.service;

import com.example.productapp.domain.ProductUser;
import com.example.productapp.domain.Products;
import com.example.productapp.repository.ProductsRepository;
import com.example.productapp.repository.UserProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProductImpl implements UserProductService{

    @Autowired
    private UserProductsRepository userProductsRepository;

    @Autowired
   private ProductsRepository productsRepository;

    @Override
    public ProductUser addUser(ProductUser productUser) {
     return  userProductsRepository.insert(productUser);
    }

    @Override
    public ProductUser getUserDetails(String email) {
      return userProductsRepository.findById(email).get();
    }

    @Override
    public ProductUser addProduct(String email, Products products) {
       ProductUser user = userProductsRepository.findById(email).get();
        user.getProducts().add(products);
        return userProductsRepository.save(user);
    }

    @Override
    public List<Products> getProducts() {
        return productsRepository.findAll();
    }

    @Override
    public boolean deleteUserById(String email) {
        productsRepository.deleteById(email);
        return true;
    }

    @Override
    public List<Products> getProduct1(String email) {
        ProductUser productUser=userProductsRepository.findById(email).get();
        List<Products> products=productUser.getProducts();
        System.out.println(products);
        return products;
    }



    @Override
    public boolean deleteProductById(String id) {
        if(userProductsRepository.findById(id).isPresent()){
            userProductsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProductFromCart(String email,Products products) {
        System.out.println(email);
        System.out.println(products);
    ProductUser productUser = userProductsRepository.findById(email).get();
//    List<Products>
        System.out.println(productUser);
        System.out.println(products.getProductId());
    for (Products products1:productUser.getProducts()){
        if (products1.getProductId().equalsIgnoreCase(products.getProductId())){
            productUser.getProducts().remove(products);
            userProductsRepository.save(productUser);
            return true;
        }
    }
    return true;

    }


}
