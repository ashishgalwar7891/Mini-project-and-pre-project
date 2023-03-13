package com.example.c3s1mcAuthUser.Proxy;

import com.example.c3s1mcAuthUser.domain.UserDto;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="ProductApp",url = "localhost:7777")
public interface UserProxy {
    @PostMapping("/product-app/add-user")
    public ResponseEntity<?> sendDataToProductApp(@RequestBody UserDto userDTO);
}
