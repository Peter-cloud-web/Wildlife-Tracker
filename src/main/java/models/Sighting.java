package models;

import dao.SightingInterface;

import java.time.format.DateTimeFormatter;

public class Sighting implements SightingInterface {
    private String rangerName;
    private String animalLocation;;
    private int animal_id;
    private int id;
    private DateTimeFormatter time;

    public Sighting(String rangerName, String animalLocation, int animal_id, int id) {
        this.rangerName = rangerName;
        this.animalLocation = animalLocation;
        this.animal_id = animal_id;
        this.id = id;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public String getAnimalLocation() {
        return animalLocation;
    }

    public void setAnimalLocation(String animalLocation) {
        this.animalLocation = animalLocation;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
