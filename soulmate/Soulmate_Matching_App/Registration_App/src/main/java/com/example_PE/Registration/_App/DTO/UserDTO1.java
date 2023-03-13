package com.example_PE.Registration._App.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO1   //Mongo me data store hoga
{
    private String email_Id;
    private String name;
    private String age;
    private String gender;
    private String city;
    private String imgURL;
}
