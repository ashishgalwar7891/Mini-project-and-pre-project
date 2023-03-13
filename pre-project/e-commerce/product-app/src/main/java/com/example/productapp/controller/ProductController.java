package com.example.productapp.controller;

import com.example.productapp.domain.ProductUser;
import com.example.productapp.domain.Products;
import com.example.productapp.service.ProductService;
import com.example.productapp.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/product-app")
public class ProductController {

    @Autowired
    private ProductService productService;

    //http://localhost:7777/product-app/get-all-products
    @GetMapping("/get-all-products")
    public List<Products> getproductDetails(HttpServletRequest request){

        return productService.getAllProducts();
    }
    //http://localhost:7777/product-app/add-new-product
    @PostMapping("/add-new-product")
    public ResponseEntity<?> addproduct(@RequestBody Products products){

        return new ResponseEntity<>(productService.addProduct(products),HttpStatus.OK);
    }
}
