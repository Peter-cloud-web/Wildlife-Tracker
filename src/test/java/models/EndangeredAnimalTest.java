package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredanimal_instantiates_true(){
        EndangeredAnimal animal = new EndangeredAnimal("Rhino","ill","young",4);
        assertEquals(true,animal instanceof EndangeredAnimal);
    }




}