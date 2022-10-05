package com.example.pizasson.DataBase;

import com.example.pizasson.Model.Order;

import java.util.ArrayList;
import java.util.HashMap;

public class DBOrders {

    public ArrayList<Order> orders;

    public HashMap<String, Integer> quantityOrders;

    public int extraDrinksOrdered;

    public ArrayList<Order> pizzasCreatedOrders, extraDrinkOrders, extraDessertsOrders,
            extraMealOrders, combosOrders;

    public DBOrders(){
        orders = new ArrayList<>();
        pizzasCreatedOrders = new ArrayList<>();
        extraDrinkOrders = new ArrayList<>();
        extraDessertsOrders = new ArrayList<>();
        extraMealOrders = new ArrayList<>();
        combosOrders = new ArrayList<>();
        quantityOrders = new HashMap<>();
        extraDrinksOrdered = 0;
    }

    public DBOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public HashMap<String, Integer> getQuantityOrders() {
        return quantityOrders;
    }

    public void setQuantityOrders(HashMap<String, Integer> quantityOrders) {
        this.quantityOrders = quantityOrders;
    }
}
