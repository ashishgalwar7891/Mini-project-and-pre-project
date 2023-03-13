package com.example.productapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.ClientSessionException;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class ProductUser {
    @Id
    private String email;
    private String userName;
    private String mobileNo;
    private  String address;
    private List<Products> products;
}
