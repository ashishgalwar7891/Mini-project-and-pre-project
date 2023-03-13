package com.example.c3s1mcAuthUser.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpData {

    private String userName;
    private String email ;
    private String password ;
    private String mobileNo ;
    private String address ;


}
