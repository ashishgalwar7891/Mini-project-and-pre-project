package com.example.soulmatematchingservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("USER")
public class User {
    @Id
    private String email_Id;
    private String name;
    private String age;
    private String gender;
    private String city;

}
