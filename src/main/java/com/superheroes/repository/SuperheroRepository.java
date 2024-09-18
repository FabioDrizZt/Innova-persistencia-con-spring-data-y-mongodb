package com.superheroes.repository;

import com.superheroes.model.Superhero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroRepository extends MongoRepository<Superhero, String> {
}
