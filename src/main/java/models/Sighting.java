package models;
import interfaces.SightingInterface;
import org.sql2o.Connection;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class Sighting {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return animal_id == sighting.animal_id &&
                id == sighting.id &&
                rangerName.equals(sighting.rangerName) &&
                animalLocation.equals(sighting.animalLocation);

    }

    @Override
    public int hashCode() {
        return Objects.hash(rangerName, animalLocation, animal_id, id);
    }

    public void save() {
        try(Connection con = Database.sql2o.open()) {
            String sql = "INSERT INTO sightings (animal_id, animalLocation, rangerName) VALUES (:animal_id, :animalLocation, :rangerName);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animal_id", this.animal_id)
                    .addParameter("animalLocation", this.animalLocation)
                    .addParameter("rangerName", this.rangerName)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sighting> getAll() {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM sightings;";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }
    public static Sighting find(int id) {
        try(Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE id=:id;";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

}
