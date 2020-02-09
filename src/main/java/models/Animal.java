package models;

import Interfaces.AnimalInterface;

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
}


