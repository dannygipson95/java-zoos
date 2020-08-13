package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Animal;

import java.util.List;

public interface AnimalService {
    Animal save(Animal animal);

    Animal findAnimalById(long id);

    List<Animal> findAllAnimals();
}
