package com.superheroes.controller;

import com.superheroes.model.Superhero;
import com.superheroes.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {
    @Autowired
    private SuperheroService superheroService;

    @GetMapping
    public List<Superhero> getAllSuperheroes(){
        return superheroService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Superhero> getSuperheroById(@PathVariable String id){
        Superhero superhero = superheroService.findById(id);
        if(superhero != null){
            return new ResponseEntity<>(superhero, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public Superhero createSuperhero(@RequestBody Superhero superhero){
        return superheroService.save(superhero);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSuperhero(@PathVariable String id){
        superheroService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Superhero> updateSuperhero(@PathVariable String id, @RequestBody Superhero superheroDetails) {
        Superhero superhero = superheroService.findById(id);
        if (superhero != null) {
            superhero.setName(superheroDetails.getName());
            superhero.setSuperPower(superheroDetails.getSuperPower());
            superhero.setCity(superheroDetails.getCity());
            return new ResponseEntity<>(superheroService.save(superhero), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
