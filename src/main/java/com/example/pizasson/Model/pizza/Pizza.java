package com.example.pizasson.Model.pizza;

import com.example.pizasson.Model.pizza.pizzaSizes.PizzaSizable;
import com.example.pizasson.Model.pizza.pizzaSizes.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is for the creation of the pizza
 *
 * @author Santiago Caballero
 */
public class Pizza {
    /**
     * The pizza name
     */
    private String name;
    /**
     * Pizza price
     */
    private double price;
    /**
     * Pizza Size
     */
    private String size;
    /**
     * The pizza ingredients
     */
    private ArrayList<PizzaIngredients> ingredients;

    /**
     * Constructor method where the name is received and the ingredients list is instanced
     * @param name to set the name of the pizza
     */
    public Pizza(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
    }
    /**
     * Overloading Constructor method where the name and the ingredients are received
     * @param name to set the name of the pizza
     * @param ingredients to set the pizza ingredients
     */
    public Pizza(String name, ArrayList<PizzaIngredients> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    /**
     * Method to get the pizza name
     * @return pizza name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the pizza name
     * @param name to set the name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method to get the pizza price
     * @return pizza price
     */
    public double getPrice() {
        return price;
    }
    /**
     * Method to set the pizza price
     * @param price to set the price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Method to get the pizza size
     * @return pizza size
     */
    public String getSize() {
        return size;
    }
    /**
     * Method to set the pizza size
     * @param size to set the size
     */
    public void setSize(String size) {
        this.size = size;
    }
    /**
     * Method to get the pizza ingredients
     * @return pizza ingredients
     */
    public ArrayList<PizzaIngredients> getIngredients() {
        return ingredients;
    }
    /**
     * Method to set the pizza ingredients
     * @param ingredients to set the ingredients
     */
    public void setIngredients(ArrayList<PizzaIngredients> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Method to add an ingredient to the ingredients pizza list
     * @param ingredient to add into ingredients
     */
    public void addIngredient(PizzaIngredients ingredient) {
        ingredients.add(ingredient);
    }

    /**
     * Method to get the pizza sizes of the interface PizzaSizable
     * @return the pizza sizes available
     */
    public ArrayList<PizzaSizable> getPizzaSizes() {
        return new ArrayList<>(List.of(
                new SmallPizza(),
                new MediumPizza(),
                new FamiliarPizza()
        ));
    }
}