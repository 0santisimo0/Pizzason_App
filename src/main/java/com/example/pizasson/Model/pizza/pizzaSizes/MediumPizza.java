package com.example.pizasson.Model.pizza.pizzaSizes;

import com.example.pizasson.Model.pizza.Pizza;
import com.example.pizasson.Model.pizza.PizzaIngredients;

import java.util.ArrayList;

/**
 * This method will be used to manage the medium size for the pizzas implementing
 * It implements the interface PizzaSizable to apply Open Closed principle
 * @see PizzaSizable
 *
 */
public class MediumPizza implements PizzaSizable{
    /**
     * This method gets the pizza size price depending on the ingredients and the size
     *
     * @param pizzaIngredients the pizza ingredients to increment the price depending on which ingredients the pizza has
     * @return the pizza size price
     */
    @Override
    public double getPriceSize(ArrayList<PizzaIngredients> pizzaIngredients) {
        double price = 0;
        for (PizzaIngredients pizzaIngredient:pizzaIngredients){
            price = pizzaIngredient.getCost() + price;
        }
        price*=3;
        return price;
    }

    /**
     * It gets the pizza size option name
     *
     * @return the pizza size name
     */
    @Override
    public String getSizeName() {
        return "Medium";
    }
}
