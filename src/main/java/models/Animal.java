package models;

import interfaces.AnimalInterface;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Animal {

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
        try (Connection con = Database.sql2o.open()) {
            String sql = "INSERT INTO animals (animalName, animal_id) VALUES (:animalName,:animal_id);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalName", this.animalName)
                    .addParameter("animal_id", this.animal_id)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Animal> getAll() {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM anmals";
            return con.createQuery(sql)
                    .executeAndFetch(Animal.class);

        }
    }
    public Animal findById(int id) {
        String sql = "SELECT * FROM animals WHERE id=:id;";
        try (Connection conn = Database.sql2o.open()){
            Animal animal = conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }catch (IndexOutOfBoundsException ex){
            System.out.println(ex);
            return null;
        }
    }
}


