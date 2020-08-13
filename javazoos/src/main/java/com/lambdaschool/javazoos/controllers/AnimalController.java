package com.lambdaschool.javazoos.controllers;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    AnimalService animalService;


    // http://localhost:2019/animals/count
    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> listAllAnimals(){
        List<Animal> beasties = animalService.findAllAnimals();
        return new ResponseEntity<>(beasties, HttpStatus.OK);
    }
}
