package com.example.soulmatematchingservice.repository;

import com.example.soulmatematchingservice.DTO.Interested;
import com.example.soulmatematchingservice.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends Neo4jRepository<User,String> {
    @Query("MATCH (userA:USER) - [:INTERESTED] -> (userB:USER) WHERE ID(userA) = $id RETURN userB")
    List<Map<String, Interested>> getLiked(String email);

    @Query("MATCH (userA:USER), (userB:USER) WHERE ID(userA) = $userA AND ID(userB) = $userB CREATE (userA) - [:INTERESTED] -> (userB)")
    void addInterest(String user1, String user2);


}
