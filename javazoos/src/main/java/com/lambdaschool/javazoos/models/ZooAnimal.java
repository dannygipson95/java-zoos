package com.lambdaschool.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimalId.class)
public class ZooAnimal extends Auditable implements Serializable {
    @Id
    @ManyToOne
    @JsonIgnoreProperties("zoo")
    @JoinColumn(name = "animalid", nullable = false)
    private Animal animal;

    @Id
    @ManyToOne
    @JsonIgnoreProperties("animal")
    @JoinColumn(name = "zooid")
    private Zoo zoo;

    public ZooAnimal() {
    }

    public ZooAnimal(Animal animal, Zoo zoo) {
        this.animal = animal;
        this.zoo = zoo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooAnimal that = (ZooAnimal) o;
        return ((this.animal == null) ? 0 : this.getAnimal().getAnimalid()) == ((that.animal == null) ? 0 : that.getAnimal().getAnimalid()) &&
                ((this.zoo == null) ? 0 : this.getZoo().getZooid()) == ((that.zoo == null) ? 0 : that.getZoo().getZooid());
    }

    @Override
    public int hashCode() {
        return 37;
    }
}
