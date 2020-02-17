package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void animalsight_instanciate_true(){
        Sighting sighting = new Sighting("peter","Zone A","lion");
        assertEquals(true,sighting instanceof Sighting);
    }
    @Test
    public void getName_animalInstanciateWithName_String(){
        Sighting sighting = new Sighting("Peter","zoneA","lion");
        assertEquals("Peter",sighting.getRanger_name());
    }
    @Test
    public void getLocation_animalInstanceWithLocation_String(){
        Sighting sighting = new Sighting("Peter","zoneA","lion");
        assertEquals("zoneA",sighting.getAnimal_location());
    }

    @Test
    public void save_insertObjectIntoDatabase_Animal(){
        Sighting sighting = new Sighting("Peter","zoneA","lion");
        sighting.saveSighting();
        assertTrue(Sighting.getAllSightings().get(0).equals(sighting));
    }



}
