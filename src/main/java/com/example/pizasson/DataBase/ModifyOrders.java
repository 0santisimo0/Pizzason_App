package com.example.pizasson.DataBase;

import com.example.pizasson.Model.Order;

import java.util.ArrayList;

/**
 * This class is the model to modify user orders
 */
public class ModifyOrders {
    /**
     * The orders made by the user
     */
    private ArrayList<Order> orders;

    /**
     * Class constructor to initialize the orders arraylist
     */
    public ModifyOrders(){
        orders = new ArrayList<>();
    }

    /**
     * This method gets the orders made by the user
     * @return the orders made by the user
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * This method sets the orders made by the user
     * @param orders the new orders to set the orders value
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
