package com.example.productapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Products {
    @Id
    private String productId;
    private String productName;
    private String productUrl;
    private String discription;
    private int price;

}
