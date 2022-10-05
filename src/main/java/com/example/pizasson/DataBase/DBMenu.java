package com.example.pizasson.DataBase;

import com.example.pizasson.Model.pizza.PredefinedPizza;
import java.util.ArrayList;
import java.util.List;

public class DBMenu {
    DBPredefinedPizzasIngredients dbPredefinedPizzasIngredients = new DBPredefinedPizzasIngredients();
    PredefinedPizza hawaianaPizza = new PredefinedPizza(
            dbPredefinedPizzasIngredients.hawaianaIngredients, "Hawaiana",
            "src/main/resources/images/predefinedPizzas/pizzaHawaiana.jpg"
    );
    PredefinedPizza veganPizza = new PredefinedPizza(
            dbPredefinedPizzasIngredients.veganIngredients,
            "Vegan",
            "src/main/resources/images/predefinedPizzas/veganPizza.jpeg"
    );
    PredefinedPizza cheesePizza = new PredefinedPizza(
            dbPredefinedPizzasIngredients.cheesesIngredients,
            "Cheese",
            "src/main/resources/images/predefinedPizzas/cheesePizza.jpg"
    );
    PredefinedPizza mexicanPizza = new PredefinedPizza(
            dbPredefinedPizzasIngredients.mexicanIngredients,
            "Mexican",
            "src/main/resources/images/predefinedPizzas/mexicanPizza.jpeg"
    );
    PredefinedPizza mushroomPizza = new PredefinedPizza(
            dbPredefinedPizzasIngredients.mushroomIngredients,
            "Mushroom",
            "src/main/resources/images/predefinedPizzas/mushroomPizza.jpeg"
    );
    PredefinedPizza pepperoniPizza = new PredefinedPizza(
            dbPredefinedPizzasIngredients.peperoniIngredients,
            "Pepperoni",
            "src/main/resources/images/predefinedPizzas/pepperoniPizza.jpeg"
    );

    public ArrayList<PredefinedPizza> predefinedPizzas = new ArrayList<>(List.of(
            hawaianaPizza, veganPizza, cheesePizza, mexicanPizza, mushroomPizza, pepperoniPizza
    ));
}
