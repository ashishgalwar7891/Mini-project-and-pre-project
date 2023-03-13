package com.example.c3s1mcAuthUser.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userName;
    private String email ;
    private String mobileNo ;
    private String address ;

}
