package com.example.pizasson.Model;

import java.util.ArrayList;

/**
 * This class is the model for the invoice printing
 */
public class Invoice {
    /**
     * The client object to get client information as name and nit
     */
    private final Client client;
    /**
     * The orders list made by the user
     */
    private ArrayList<Order> orders;
    /**
     * The current invoice id
     */
    private int invoiceID;

    public  Invoice(){
        client = new Client();
        orders = new ArrayList<>();
    }

    /**
     * Class constructor that sets the client and the orders list
     * @param client the client updated
     * @param orders the orders made by the user
     */
    public Invoice(Client client, ArrayList<Order> orders) {
        this.client = client;
        this.orders = orders;
    }

    /**
     * This method gets the current invoice id
     * @return the current invoice id
     */
    public int getInvoiceID() {
        return invoiceID;
    }

    /**
     * This method sets the current invoice id to the received one
     * @param invoiceID The new invoiceID value
     */
    public void setInvoiceId(int invoiceID){
        this.invoiceID = invoiceID;
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
     * @param orders the new orders value
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    /**
     * This method gets the current client for the invoice information
     * @return the client object
     */
    public Client getClient() {
        return client;
    }
}
