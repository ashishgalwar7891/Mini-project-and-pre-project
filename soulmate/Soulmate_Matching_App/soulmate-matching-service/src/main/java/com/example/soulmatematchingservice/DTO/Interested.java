package com.example.soulmatematchingservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interested {
    private String email_Id;
    private String name;
    private String age;
    private String gender;
    private String city;

    @Relationship(type = "INTERESTED", direction = Relationship.Direction.OUTGOING)
    private List<Interested> interested;

//    @Relationship(type = "NOT_INTERESTED", direction = Relationship.Direction.OUTGOING)
//    private List<NotInterested> notInterested;
}
