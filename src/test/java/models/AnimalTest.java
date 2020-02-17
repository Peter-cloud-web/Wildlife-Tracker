package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal= new Animal("Rhino");
        assertEquals(true, testAnimal instanceof Animal);
    }
    @Test
    public void getName_animalInstantiatewithName_String(){
        Animal testAnimal= new Animal("Rhino");
        assertEquals("Rhino",testAnimal.getAnimalName());
    }


    @Test
    public void getId_animalInstantiatewithId_int(){
        Animal testAnimal= new Animal("Rhino");
        assertEquals(0,testAnimal.getId());
    }
    @Test
    public void save_insertObjectIntoDatabase_Animal(){
        Animal testAnimal= new Animal("Rhino");
        testAnimal.saveAnimal();
        assertTrue(Animal.getAll().get(0).equals(testAnimal));
    }
    @Test
    public void find_returns_animal()
    {
        Animal animal1 = new Animal("Rhino");
        animal1.saveAnimal();
        assertEquals(animal1 ,Animal.findById(animal1.getId()));
    }
    @Test
    public void delete_deleteAnimalFromDatabase_0(){
        Animal testAnimal = new Animal("Rhino");
        testAnimal.saveAnimal();
        testAnimal.delete();
        assertEquals(0,Animal.getAll().size());
    }


}

