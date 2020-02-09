package models;

import interfaces.AnimalInterface;
import org.h2.engine.Database;
import org.sql2o.Connection;

import java.util.Objects;

public class Animal implements AnimalInterface {

    private String animalName;
    private String animalHealth;
    private int animalAge;
    private int animal_id;
    private int id;


    public Animal(String animalName, String animalHealth, int animalAge, int id) {
        this.animalName = animalName;
        this.animalHealth = animalHealth;
        this.animalAge = animalAge;
        this.animal_id = animal_id;
        this.id = id;
    }


    public int getAnimal_id() {
        return animal_id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalHealth() {
        return animalHealth;
    }

    public void setAnimalHealth(String animalHealth) {
        this.animalHealth = animalHealth;
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalAge == animal.animalAge &&
                animal_id == animal.animal_id &&
                id == animal.id &&
                Objects.equals(animalName, animal.animalName) &&
                Objects.equals(animalHealth, animal.animalHealth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalName, animalHealth, animalAge, animal_id, id);
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES (:name);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalName", this.animalName)
                    .executeUpdate()
                    .getKey();
        }


    }


