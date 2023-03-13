package com.backend.authapp.proxy;

import com.backend.authapp.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// http://localhost:5555/product-app-v1/add-user
@FeignClient(name="movie-service", url="localhost:5555")
public interface UserProxy {
    @PostMapping("/movie-app-v1/add-user")
    public abstract ResponseEntity<?> sendUserDtoToProductApp(@RequestBody UserDTO userDTO);
 }












