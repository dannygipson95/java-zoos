package com.lambdaschool.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "animal")
public class Animal extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    private String animaltype;

    @OneToMany(mappedBy = "animal",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "animal")
    private Set<ZooAnimal> zoo = new HashSet<>();

    public Animal() {
    }

    public Animal(String animaltype) {
        this.animaltype = animaltype;
    }

    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public Set<ZooAnimal> getZoo() {
        return zoo;
    }

    public void setZoo(Set<ZooAnimal> zoo) {
        this.zoo = zoo;
    }
}
