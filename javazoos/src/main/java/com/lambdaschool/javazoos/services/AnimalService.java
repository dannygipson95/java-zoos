package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.view.AnimalCountZoos;

import java.util.List;

public interface AnimalService {
    List<Animal> findAllAnimals();

    List<AnimalCountZoos> getAnimalCountZoos();
}
