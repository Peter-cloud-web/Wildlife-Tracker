package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Animal {

    private String animalName;
    private int id;


    public Animal(String animalName) {
        this.animalName = animalName;
        this.id = id;
    }




    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
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
        return id == animal.id &&
                animalName.equals(animal.animalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalName, id);
    }

    public void saveAnimal() {
        try (Connection con = Database.sql2o.open()) {
            String sql = "INSERT INTO animals (animalName) VALUES (:animalName);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalName", this.animalName)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Animal> getAll() {

        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM animals ORDER BY id DESC;";
            return con.createQuery(sql)
                    .executeAndFetch(Animal.class);

        }
    }
    public static Animal findById(int id) {
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
    public void delete() {
        try(Connection con = Database.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id=:id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
    public void updateName(String animalName) {
        try(Connection con = Database.sql2o.open()) {
            String sql = "UPDATE animals SET animalName=:animalName WHERE id=:id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("animalName", this.animalName)
                    .executeUpdate();
        }
    }
}


