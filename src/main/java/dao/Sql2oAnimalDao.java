package dao;

import models.Animal;
import org.h2.engine.Database;
import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
//import java.util.Objects;
//
//public class Sql2oAnimalDao implements AnimalDao {
//
//    private final Sql2o sql2o;
//
//    public Sql2oTaskDao(Sql2o sql2o) {
//        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it
//
//    }
//    @Override
//    public void saveAnimal(Animal animal) {
//        try (Connection conn = Database.sql2o.open()){
//            String sql = "INSERT INTO  animals(animal_id, animal_name ) VALUES (:animal_id, :animal_name);";
//            this.id = (int) conn.createQuery(sql, true)
//                    .addParameter("animal_id", this.animal_id)
//                    .addParameter("animal_name", this.animal_name)
//                    .executeUpdate()
//                    .getKey();
//        }
//    }





