package com.example.c3s1mcAuthUser.repository;

import com.example.c3s1mcAuthUser.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
//    public abstract User findByEmailIdAndPassword(String email, String password);
}
