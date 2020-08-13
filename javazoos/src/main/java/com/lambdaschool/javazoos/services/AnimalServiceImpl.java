package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "animalservice")
public class AnimalServiceImpl implements AnimalService{
    @Autowired
    AnimalRepository animalrepos;

    @Override
    public Animal save(Animal animal) {
        return null;
    }

    @Override
    public Animal findAnimalById(long id) {
        return animalrepos.findById(id).get();
    }

    @Override
    public List<Animal> findAllAnimals() {
        List<Animal> list = new ArrayList<>();
        animalrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
