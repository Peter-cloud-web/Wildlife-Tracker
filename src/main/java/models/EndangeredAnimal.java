package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;



public class EndangeredAnimal {
    private String animal_name;
    private String animal_health;
    private String animal_age;
    private int id;

    public EndangeredAnimal(String animal_name, String animal_health, String animal_age) {
        this.animal_name = animal_name;
        this.animal_health = animal_health;
        this.animal_age = animal_age;
        this.id = id;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public String getAnimal_health() {
        return animal_health;
    }

    public void setAnimal_health(String animal_health) {
        this.animal_health = animal_health;
    }

    public String getAnimal_age() {
        return animal_age;
    }

    public void setAnimal_age(String animal_age) {
        this.animal_age = animal_age;
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
        EndangeredAnimal that = (EndangeredAnimal) o;
        return id == that.id &&
                animal_name.equals(that.animal_name) &&
                animal_health.equals(that.animal_health) &&
                animal_age.equals(that.animal_age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animal_name, animal_health, animal_age, id);
    }

    public void saveEndangered(){
        try(Connection conn = Database.sql2o.open()){
            String sql = "INSERT INTO  endangered_animals(animal_name, animal_age, animal_health ) VALUES (:animal_name, :animal_age,:animal_health);";
            this.id = (int) conn.createQuery(sql, true)
                    .addParameter("animal_name", this.animal_name)
                    .addParameter("animal_age", this.animal_age)
                    .addParameter("animal_health", this.animal_health)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<EndangeredAnimal> getAllAnimals() {
        try (Connection conn = Database.sql2o.open()) {
            String sql = "SELECT * FROM endangered_animals ORDER BY id DESC;";
            return conn.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }
    public EndangeredAnimal findById(int id) {
        String sql = "SELECT * FROM endangered_animals WHERE id=:id";
        try (Connection conn = Database.sql2o.open()){
            EndangeredAnimal animal = conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }catch (IndexOutOfBoundsException ex){
            System.out.println(ex);
            return null;
        }
    }
    public void delete() {
        try(Connection con = Database.sql2o.open()) {
            String sql = "DELETE FROM endangered_animals; WHERE id=:id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }


    }
