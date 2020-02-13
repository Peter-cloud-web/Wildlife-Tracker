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
            model.put("allEndangered", EndangeredAnimal.getAllAnimals());
            model.put("allAnimals", Animal.getAll());
            model.put("allSightings", Sighting.getAllSightings());
            return new ModelAndView(model,"registry.hbs");
        },new HandlebarsTemplateEngine());

        get("/registry", (req,res)->{
                    Map<String, Object> model = new HashMap<>();
                    model.put("allAnimals", Animal.getAll());
                    model.put("allEndangered", EndangeredAnimal.getAllAnimals());
                    model.put("allSightings", Sighting.getAllSightings());
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
            String health = req.queryParams("health");
            String age = req.queryParams("age");
            Animal newAnimal = new Animal(name);
            newAnimal.saveAnimal();
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());


        post("/new/sighting",(req,res)->{
            Map<String,Object>model = new HashMap<>();
            String rangerName = req.queryParams("rangerName");
            String animalLocation = req.queryParams("animalLocation");
            Sighting sighting = new Sighting(rangerName,animalLocation);
            sighting.save();
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        post("new/endangered" ,(req,res)->{
            Map<String,Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String health = req.queryParams("health");
            String age = req.queryParams("age");
            EndangeredAnimal endangered = new EndangeredAnimal(name,health,age);
            endangered.saveEndangered();
            model.put("endangered",endangered);
            model.put("template", "success.hbs");
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

    }
}