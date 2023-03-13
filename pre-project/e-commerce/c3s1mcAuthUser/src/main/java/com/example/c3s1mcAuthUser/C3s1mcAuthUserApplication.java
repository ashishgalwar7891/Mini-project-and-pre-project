package com.example.c3s1mcAuthUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication

@EnableEurekaClient
@EnableFeignClients
public class C3s1mcAuthUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(C3s1mcAuthUserApplication.class, args);
	}

}
