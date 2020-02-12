package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal= new Animal("Rhino", "ill",456,4);
        assertEquals(true, testAnimal instanceof Animal);
    }
    @Test
    public void getName_animalInstantiatewithName_String(){
        Animal testAnimal= new Animal("Rhino", "ill",456,4);
        assertEquals("Rhino",testAnimal.getAnimalName());
    }
    @Test
    public void getHealth_animalInstantiatewithHealth_String(){
        Animal testAnimal= new Animal("Rhino", "ill",456,4);
        assertEquals("ill",testAnimal.getAnimalHealth());
    }
    @Test
    public void getAge_animalInstantiatewithAge_int(){
        Animal testAnimal= new Animal("Rhino", "ill",456,4);
        assertEquals(456,testAnimal.getAnimalAge());
    }
    @Test
    public void getId_animalInstantiatewithId_int(){
        Animal testAnimal= new Animal("Rhino", "ill",456,4);
        assertEquals(4,testAnimal.getId());
    }
}

