package com.example.pizasson.Model;

import java.util.ArrayList;

/**
 * This class is the model for HomeOrder containing the needed attributes
 *
 */
public class HomeOrder {
    /**
     * An orders ArrayList to manage all the user orders from the different stages
     */
    private ArrayList<Order> orders;
    /**
     * The pizzas ordered from menu number
     */
    private int pizzasOrderedNumber;
    /**
     * The pizzas built with custom ingredients number
     */
    private int pizzasBuiltNumber;
    /**
     * The combos ordered by user number
     */
    private int combosOrderedNumber;
    /**
     * The extras ordered by user number
     */
    private int extrasOrderedNumber;

    /**
     * Class constructor initializing the orders and setting the order numbers in 0
     */
    public HomeOrder(){
        orders = new ArrayList<>();
        pizzasBuiltNumber = 0;
        pizzasOrderedNumber = 0;
        combosOrderedNumber = 0;
        extrasOrderedNumber = 0;
    }

    /**
     * Class constructor overload in case it's necessary to set the attributes
     * @param orders all the orders arrayList
     * @param pizzasOrderedNumber the pizzas ordered from menu number
     * @param pizzasBuiltNumber the pizzas built number
     * @param combosOrderedNumber the combos ordered number
     * @param extrasOrderedNumber  the extras ordered number
     */
    public HomeOrder(
            ArrayList<Order> orders, int pizzasOrderedNumber, int pizzasBuiltNumber,
            int combosOrderedNumber, int extrasOrderedNumber
    ) {
        this.orders = orders;
        this.pizzasOrderedNumber = pizzasOrderedNumber;
        this.pizzasBuiltNumber = pizzasBuiltNumber;
        this.combosOrderedNumber = combosOrderedNumber;
        this.extrasOrderedNumber = extrasOrderedNumber;
    }

    /**
     * This method increments in one the pizzas ordered from the menu by user
     */
    public void increaseOnePizzaOrdered(){
        pizzasOrderedNumber++;
    }

    /**
     * This method increments in one the pizzas built with custom ingredients by user
     */
    public void increaseOnePizzaBuilt(){
        pizzasBuiltNumber++;
    }

    /**
     * This method increments in one the combos ordered by user
     */
    public void increaseOneComboOrdered(){
        combosOrderedNumber++;
    }

    /**
     * This method increments in one the extras ordered by user
     */
    public void increaseOneExtraOrdered(){
        extrasOrderedNumber++;
    }

    /**
     * This method adds an order to the whole orders ArrayList
     */
    public void addOneOrder(Order order){
        orders.add(order);
    }

    /**
     * This method gets the user orders
     * @return the whole orders by user
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * This method set the user orders
     * @param orders the new orders ArrayList value
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    /**
     * This method gets the pizzas ordered from menu number
     * @return the pizzas ordered from menu
     */
    public int getPizzasOrderedNumber() {
        return pizzasOrderedNumber;
    }

    /**
     * This method sets the pizzas ordered from menu number
     * @param pizzasOrderedNumber the new pizzas ordered from menu number
     */
    public void setPizzasOrderedNumber(int pizzasOrderedNumber) {
        this.pizzasOrderedNumber = pizzasOrderedNumber;
    }

    /**
     * This method gets the pizzas built with custom ingredients by user number
     * @return the pizzas built with custom ingredients by user number
     */
    public int getPizzasBuiltNumber() {
        return pizzasBuiltNumber;
    }

    /**
     * This method sets the pizzas built with custom ingredients by user number
     * @param pizzasBuiltNumber the new pizzas built with custom ingredients by user number value
     */
    public void setPizzasBuiltNumber(int pizzasBuiltNumber) {
        this.pizzasBuiltNumber = pizzasBuiltNumber;
    }

    /**
     * This method gets the combos ordered by user number
     * @return the combos ordered by user number
     */
    public int getCombosOrderedNumber() {
        return combosOrderedNumber;
    }

    /**
     * This method sets the combos ordered by user number
     * @param combosOrderedNumber the new combos ordered by user number value
     */
    public void setCombosOrderedNumber(int combosOrderedNumber) {
        this.combosOrderedNumber = combosOrderedNumber;
    }

    /**
     * This method gets the extras ordered by user number
     * @return the extras ordered by user number
     */
    public int getExtrasOrderedNumber() {
        return extrasOrderedNumber;
    }

    /**
     * This method sets the extras ordered by user number
     * @param extrasOrderedNumber the new extras ordered by user number value
     */
    public void setExtrasOrderedNumber(int extrasOrderedNumber) {
        this.extrasOrderedNumber = extrasOrderedNumber;
    }
}
