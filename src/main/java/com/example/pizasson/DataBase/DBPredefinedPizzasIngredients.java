package com.example.pizasson.DataBase;

import com.example.pizasson.Model.pizza.PizzaIngredients;

import java.util.ArrayList;
import java.util.List;

public class DBPredefinedPizzasIngredients {

    public ArrayList<PizzaIngredients> hawaianaIngredients = new ArrayList<>(List.of(PizzaIngredients.PINEAPPLE,
            PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.HAM, PizzaIngredients.TOMATO_SAUCE, PizzaIngredients.CORN));

    public ArrayList<PizzaIngredients> peperoniIngredients = new ArrayList<>(List.of(PizzaIngredients.PEPPERONI,
            PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.HAM, PizzaIngredients.TOMATO_SAUCE));

    public ArrayList<PizzaIngredients> mexicanIngredients = new ArrayList<>(List.of(PizzaIngredients.SAUSAGE,
            PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.ONION, PizzaIngredients.JALAPENO, PizzaIngredients.TOMATO_SAUCE));

    public ArrayList<PizzaIngredients> cheesesIngredients = new ArrayList<>(List.of(
            PizzaIngredients.NORMAL_CHEESE, PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.PARMESAN_CHEESE,
            PizzaIngredients.ROQUEFORT_CHEESE, PizzaIngredients.TOMATO_SAUCE));
    
    public ArrayList<PizzaIngredients> mushroomIngredients = new ArrayList<>(List.of(PizzaIngredients.MUSHROOM,
            PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.HAM, PizzaIngredients.TOMATO_SAUCE, PizzaIngredients.CORN));

    public ArrayList<PizzaIngredients> veganIngredients = new ArrayList<>(List.of(PizzaIngredients.BROCCOLI,
            PizzaIngredients.TOFU_CHEESE, PizzaIngredients.OLIVES, PizzaIngredients.CORN));

}
