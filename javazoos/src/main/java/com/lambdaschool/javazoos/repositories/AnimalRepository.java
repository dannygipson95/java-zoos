package com.lambdaschool.javazoos.repositories;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.view.AnimalCountZoos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query(value = "SELECT a.animaltype AS animaltype, a.animalid as animalid, COUNT(z.animalid) AS countzoos\n" +
            "FROM animal a LEFT JOIN zooanimals z \n" +
            "ON a.animalid =z.animalid\n" +
            "GROUP BY a.animalid\n" +
            "ORDER BY a.animaltype",
            nativeQuery = true)
    List<AnimalCountZoos> getCountZoos();
}
