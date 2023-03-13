package com.example.productapp.controller;

import com.example.productapp.domain.ProductUser;
import com.example.productapp.domain.Products;
import com.example.productapp.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product-app")
public class UserProductControlller {
    @Autowired
    private UserProductService userProductService;

    // http://localhost:7777/product-app/add-user  [POST]
    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody ProductUser productUser) {
        productUser.setProducts(new ArrayList<Products>());
        return new ResponseEntity(userProductService.addUser(productUser), HttpStatus.OK);
    }

    // http://localhost:7777/product-app/add-product-to-user  [POST]
    @PostMapping("/add-product-to-user")
    public ResponseEntity<?> addproduct(@RequestBody Products products, HttpServletRequest request) {
        String current_email = (String) request.getAttribute("current_user_email");
        return new ResponseEntity<>(userProductService.addProduct(current_email, products), HttpStatus.OK);
    }

    //http://localhost:7777/product-app/get-user-product
    @GetMapping("/get-user-product")
    public ResponseEntity<?> getProduct1(HttpServletRequest request) {
        String email = (String) request.getAttribute("current_user_email");
        return new ResponseEntity<>(userProductService.getProduct1(email), HttpStatus.OK);
    }

//    @DeleteMapping("/delete-cart-product")
//    public ResponseEntity<?> deleteCartTrack(HttpServletRequest request) {
//        String productId = (String) request.getAttribute("current_user_email");
//        return new ResponseEntity<>(userProductService.getProduct1(productId), HttpStatus.OK);
//    }

    //http://localhost:7777/product-app/get-user-details
    @GetMapping("/get-user-details")
    public ResponseEntity<?> getUserDetails(HttpServletRequest request) {
        String email = (String) request.getAttribute("current_user_email");
        return new ResponseEntity<>(userProductService.getUserDetails(email), HttpStatus.OK);
    }
    //http://localhost:7777/product-app/delete-cart-product/{pid}
    @DeleteMapping("/delete-cart-product")
    public ResponseEntity<?> deleteProductFromCart(HttpServletRequest request,@RequestBody Products products) {
        System.out.println(products);
        String email = (String) request.getAttribute("current_user_email");
//        System.out.println(pid);
        System.out.println(products.getProductId());
        return new ResponseEntity<>(userProductService.deleteProductFromCart(email,products), HttpStatus.OK);
    }
}
