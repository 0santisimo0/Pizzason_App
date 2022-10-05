package com.example.pizasson.Model.pizza.pizzaSizes;

import com.example.pizasson.Model.pizza.PizzaIngredients;

import java.util.ArrayList;

/**
 * This interface is used to apply open closed in the different pizza sizes options
 *
 */
public interface PizzaSizable {
    /**
     * This method gets the pizza size price depending on the ingredients and the size
     * @param pizzaIngredients the pizza ingredients to increment the price depending on which ingredients the pizza has
     * @return the pizza size price
     */
    double getPriceSize(ArrayList<PizzaIngredients> pizzaIngredients);

    /**
     * It gets the pizza size option name
     * @return the pizza size name
     */
    String getSizeName();
}
