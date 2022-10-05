package com.example.pizasson.Model.pizza;
import com.example.pizasson.Model.Order;
import com.example.pizasson.Model.pizza.pizzaSizes.FamiliarPizza;
import com.example.pizasson.Model.pizza.pizzaSizes.MediumPizza;
import com.example.pizasson.Model.pizza.pizzaSizes.PizzaSizable;
import com.example.pizasson.Model.pizza.pizzaSizes.SmallPizza;
import java.util.ArrayList;
import java.util.List;


public class PizzasMenu {

    /**
     * The current pizzas ordered number by the user
     */
    private int pizzasOrderedNumber;

    /**
     * An ArrayList designated to contain all the predefined pizzas options in the menu to order.
     */
    private ArrayList<PredefinedPizza> predefinedPizzas;

    /**
     * An ArrayList designated to contain the current orders to be sent to the HomeOrder
     */
    private ArrayList<Order> orders;

    /**
     * Class constructor to set the predefined pizzas in the menu ArrayList
     * @param predefinedPizzas
     */
    public PizzasMenu(ArrayList<PredefinedPizza> predefinedPizzas) {
        this.predefinedPizzas = predefinedPizzas;
    }

    /**
     * This method gets the predefined pizzas in the menu
     * @return the predefined pizzas
     */
    public ArrayList<PredefinedPizza> getPredefinedPizzas() {
        return predefinedPizzas;
    }

    /**
     * This method sets the predefined pizzas in the menu
     * @param predefinedPizzas an ArrayList to set the predefined pizzas
     */
    public void setPredefinedPizzas(ArrayList<PredefinedPizza> predefinedPizzas) {
        this.predefinedPizzas = predefinedPizzas;
    }

    /**
     * This method gets the pizzas ordered number by the user
     * @return the pizzas ordered number
     */
    public int getPizzasOrderedNumber() {
        return pizzasOrderedNumber;
    }

    /**
     * This method sets the pizzas ordered number
     * @param pizzasOrderedNumber the new pizzas ordered number
     */
    public void setPizzasOrderedNumber(int pizzasOrderedNumber) {
        this.pizzasOrderedNumber = pizzasOrderedNumber;
    }

    /**
     * This method increments in one the pizzas ordered number
     */
    public void addOnePizzaOrdered(int quantityToAdd) {
        pizzasOrderedNumber+=quantityToAdd;
    }

    /**
     * This method gets an ArrayList with the pizza sizes options to order for each pizza
     * @return the pizza sizes options
     */
    public ArrayList<PizzaSizable> getPizzaSizes(){
        return new ArrayList<>(List.of(new SmallPizza(), new MediumPizza(), new FamiliarPizza()));
    }

    /**
     * This method gets the current orders made by the user in the Menu
     * @return the current orders made in the Menu
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * This method sets the current orders made by the user in the Menu
     * @param orders the new current orders made in the Menu
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    /**
     * This method adds a new order to the orders ArrayList
     */
    public void addANewOrder(Order order) {
        orders.add(order);
    }
}
