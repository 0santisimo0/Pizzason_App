package com.example.pizasson.Model;

/**
 * This class contains the orders.
 *
 */
public class Order {
    /**
     * Is the order title
     */
    private String orderTitle;
    /**
     * Is the order description
     */
    private String descriptionOrder;
    /**
     * Is the unit price of an order
     */
    private double unitaryCost;

    /**
     * Is the order quantity
     */
    private int quantity;

    /**
     * This is the constructor method
     * @param titleOrder of the order
     * @param descriptionOrder of the order
     * @param quantity of the order
     * @param unitaryCost of the order
     */
    public Order(String titleOrder, String descriptionOrder,  int quantity ,double unitaryCost) {
        this.orderTitle = titleOrder;
        this.descriptionOrder = descriptionOrder;
        this.unitaryCost = unitaryCost;
        this.quantity = quantity;
    }

    /**
     * This method gets the title of the order.
     * @return
     */
    public String getOrderTitle() {
        return orderTitle;
    }

    /**
     * This method sets the title of the order
     * @param orderTitle
     */

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }
    /**
     * This method gets the description of the order.
     * @return
     */

    public String getDescriptionOrder() {
        return descriptionOrder;
    }

    /**
     * This method sets the description of the order
     * @param descriptionOrder of the order
     */
    public void setDescriptionOrder(String descriptionOrder) {
        this.descriptionOrder = descriptionOrder;
    }

    /**
     * This method gets the unitary cost of the order.
     * @return unitaryCost
     */
    public double getUnitaryCost() {
        return unitaryCost;
    }

    /**
     * This method sets the unitary Cost of the order
     * @param unitaryCost
     */
    public void setUnitaryCost(double unitaryCost) {
        this.unitaryCost = unitaryCost;
    }
    /**
     * This method gets the quantity of the order.
     * @return
     */

    public int getQuantity() {
        return quantity;
    }

    /**
     * This method sets the quantity of the order
     * @param quantity of the order
     */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
