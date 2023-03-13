package com.example_PE.Login_App.repository;

import com.example_PE.Login_App.domain.LoginData;
import com.example_PE.Registration._App.DTO.UserDTO1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<LoginData,String> {
    LoginData save(LoginData user);
}
