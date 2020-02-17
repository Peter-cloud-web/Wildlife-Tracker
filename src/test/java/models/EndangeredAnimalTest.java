package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredanimal_instantiates_true(){
        EndangeredAnimal animal = new EndangeredAnimal("Rhino","ill","young");
        assertEquals(true,animal instanceof EndangeredAnimal);
    }
    @Test
    public void getName_animalInstantiateWithName_String(){
        EndangeredAnimal animal = new EndangeredAnimal("Rhino","ill","young");
        assertEquals("Rhino",animal.getAnimal_name());
    }
    @Test
    public void getHealth_animalInstantiateWithHealth_String(){
        EndangeredAnimal animal = new EndangeredAnimal("Rhino","ill","young");
        assertEquals("ill",animal.getAnimal_health());
    }
    @Test
    public void getAge_animalInstantiateWithAge_String(){
        EndangeredAnimal animal = new EndangeredAnimal("Rhino","ill","young");
        assertEquals("young",animal.getAnimal_age());
    }
    @Test
    public void save_insertObjectIntoDatabase_Animal(){
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Rhino","ill","young");
        endangeredAnimal.saveEndangered();
        assertTrue(EndangeredAnimal.getAllAnimals().get(0).equals(endangeredAnimal));
    }
    @Test
    public void delete_deleteAnimalFromDatabase_0(){
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Rhino","ill","young");
        endangeredAnimal.saveEndangered();
        endangeredAnimal.delete();
        assertEquals(0,EndangeredAnimal.getAllAnimals().size());
    }
    @Test
    public void find_returns_animal()
    {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Rhino","ill","young");
        endangeredAnimal.saveEndangered();
        assertEquals(endangeredAnimal , EndangeredAnimal.findById(endangeredAnimal.getId()));
    }

}