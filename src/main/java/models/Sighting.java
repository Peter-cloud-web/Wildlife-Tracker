package models;
import org.sql2o.Connection;
import java.util.List;
import java.util.Objects;


public class Sighting {
    private String ranger_name;
    private String animal_location;
    private String animal_sighted;
    private int id;

    public Sighting(String ranger_name, String animal_location, String animal_sighted) {
        this.ranger_name = ranger_name;
        this.animal_location = animal_location;
        this.id = id;
    }

    public String getRanger_name() {
        return ranger_name;
    }

    public void setRanger_name(String ranger_name) {
        this.ranger_name = ranger_name;
    }

    public String getAnimal_location() {
        return animal_location;
    }

    public void setAnimal_location(String animal_location) {
        this.animal_location = animal_location;
    }

    public String getAnimal_sighted() {
        return animal_sighted;
    }

    public void setAnimal_sighted(String animal_sighted) {
        this.animal_sighted = animal_sighted;
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
        return id == sighting.id &&
                this.ranger_name.equals(sighting.ranger_name) &&
                this.animal_location.equals(sighting.animal_location) &&
                this.animal_sighted.equals(sighting.animal_sighted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranger_name, animal_location, animal_sighted);
    }

    public void saveSighting() {
        try(Connection con = Database.sql2o.open()) {
            String sql = "INSERT INTO sightings( animal_location, ranger_name,animal_sighted) VALUES ( :animal_location, :ranger_name,:animal_sighted);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animal_sighted", this.animal_sighted)
                    .addParameter("animal_location", this.animal_location)
                    .addParameter("ranger_name", this.ranger_name)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sighting> getAllSightings() {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM sightings;";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }
    public static Sighting findById(int id) {
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
    public void delete() {
        try(Connection con = Database.sql2o.open()) {
            String sql = "DELETE FROM sightings WHERE id=:id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

}
