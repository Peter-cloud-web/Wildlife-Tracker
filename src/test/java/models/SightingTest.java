package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void animalsight_instanciate_true(){
        Sighting sighting = new Sighting("Peter","zoneA");
        assertEquals(true,sighting instanceof Sighting);
    }
    @Test
    public void getName_animalInstanciateWithName_String(){
        Sighting sighting = new Sighting("Peter","zoneA");
        assertEquals("Peter",sighting.getRangerName());
    }
    @Test
    public void getLocation_animalInstanceWithLocation_String(){
        Sighting sighting = new Sighting("Peter","zoneA");
        assertEquals("zoneA",sighting.getAnimalLocation());
    }

    @Test
    public void save_insertObjectIntoDatabase_Animal(){
        Sighting sighting = new Sighting("Peter","zoneA");
        sighting.save();
        assertTrue(Sighting.getAll().get(0).equals(sighting));
    }




}