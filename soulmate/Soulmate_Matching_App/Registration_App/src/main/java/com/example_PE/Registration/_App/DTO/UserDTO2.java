package com.example_PE.Registration._App.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO2 //Mysql me data store hoga
{
    private String email_Id;
    private String password;
    private String gender;
}
