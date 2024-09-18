package com.superheroes.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="superheroes")
@Data
public class Superhero {
    @Id
    private String id; // En mongoDB el id es de tipo STRING
    private String name;
    private String superPower;
    private String city;
}
