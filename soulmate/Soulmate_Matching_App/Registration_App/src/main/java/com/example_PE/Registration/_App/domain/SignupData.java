package com.example_PE.Registration._App.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class SignupData {
    @Id
    private String email_Id;
    private String password;
    private String name;
    private String age;
    private String gender;
    private String city;
    private String imgURL;
}
