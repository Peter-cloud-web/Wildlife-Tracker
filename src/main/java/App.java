import models.Animal;
import models.EndangeredAnimal;
import models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");

        get("/",(req,res)->{
            Map<String, Object> model = new HashMap<>();
//            model.put("allEndangered", EndangeredAnimal.getAllAnimals());
//            model.put("allAnimals", Animal.getAll());
//            model.put("allSightings", Sighting.getAll());
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());
        get("/registry", (req,res)->{
                    Map<String, Object> model = new HashMap<>();
//                    model.put("allAnimals", Animal.getAll());
//                    model.put("allEndangered", EndangeredAnimal.getAllAnimals());
//                    model.put("allSightings", Sighting.getAll());
                    return new ModelAndView(model,"registry.hbs");
                }, new HandlebarsTemplateEngine());

        get("/animal/new", (req,res)-> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"Animal.hbs");
        }, new HandlebarsTemplateEngine());
        get("/endangered/new", (req,res)-> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"Endangered.hbs");
        }, new HandlebarsTemplateEngine());
        get("/sighting", (req,res)-> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"sighting.hbs");
        }, new HandlebarsTemplateEngine());


        post("/new/animal",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int animal_id = Integer.parseInt(req.queryParams("animal_id"));
            String health = req.queryParams("health");
            int age = Integer.parseInt(req.queryParams("age"));
            Animal newAnimal = new Animal(name);
            newAnimal.saveAnimal();
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        post("/new/sighting",(req,res)->{
            Map<String,Object>model = new HashMap<>();
            String rangerName = req.queryParams("rangerName");
            String animalLocation = req.queryParams("animalLocation");
            int id = Integer.parseInt(req.queryParams("id"));
            int animal_id = Integer.parseInt(req.queryParams("animal_id"));
            Sighting sighting = new Sighting(rangerName,animalLocation,id,animal_id);
            sighting.save();
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        post("new/endangered" ,(req,res)->{
            Map<String,Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String health = req.queryParams("health");
            String age = req.queryParams("age");
            int id = Integer.parseInt(req.queryParams("id"));
            EndangeredAnimal endangered = new EndangeredAnimal(name,health,age,id);
            endangered.saveAnimal(endangered);
            model.put("endangered",endangered);
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

    }
}
