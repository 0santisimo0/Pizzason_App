package com.example.pizasson.Model.pizza;

import java.util.ArrayList;

/**
 * This class will be used for the predefined pizzas in the restaurant menu
 *
 */

public class PredefinedPizza extends Pizza {
    /**
     * This is a string that contains the image path source
     */
    private final String imageSource;

    /**
     * Class constructor that passes ingredients and pizzaName to his father
     * @param ingredients an ArrayList of PizzaIngredients with all the pizza ingredients
     * @param pizzaName the pizza name
     * @param imageSource the image path source
     */
    public PredefinedPizza(ArrayList<PizzaIngredients> ingredients, String pizzaName, String imageSource) {
        super(pizzaName, ingredients);
        this.imageSource = imageSource;
    }

    /**
     * This method gets the imageSource
     * @return the image source
     */
    public String getImageSource() {
        return imageSource;
    }
}
