package models;
import org.sql2o.Connection;
import java.util.List;
import java.util.Objects;


public class Sighting {
    private String rangerName;
    private String animalLocation;;
    private int id;

    public Sighting(String rangerName, String animalLocation) {
        this.rangerName = rangerName;
        this.animalLocation = animalLocation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return id == sighting.id &&
                rangerName.equals(sighting.rangerName) &&
                animalLocation.equals(sighting.animalLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rangerName, animalLocation,id);
    }

    public void save() {
        try(Connection con = Database.sql2o.open()) {
            String sql = "INSERT INTO sightings ( animalLocation, rangerName) VALUES ( :animalLocation, :rangerName);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalLocation", this.animalLocation)
                    .addParameter("rangerName", this.rangerName)
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
