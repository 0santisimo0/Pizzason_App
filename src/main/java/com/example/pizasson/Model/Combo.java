package com.example.pizasson.Model;

import com.example.pizasson.Model.Extras.Extra;
import com.example.pizasson.Model.Extras.ExtraDessertsSize.Portion450gr;
import com.example.pizasson.Model.Extras.ExtraDrink;
import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.Litters2;
import com.example.pizasson.Model.Extras.ExtraServingOfDesserts;
import com.example.pizasson.Model.pizza.Pizza;
import com.example.pizasson.Model.pizza.pizzaSizes.MediumPizza;

import java.util.ArrayList;

/**
 * This class contains the restaurant combos.
 *
 */
public class Combo {
    /**
     * Is the combo name
     */
    private String comboName;
    /**
     * Is the combo price
     */
    private double comboPrice;
    /**
     * Is the list of combo extras
     */
    private ArrayList<Extra> extras;
    /**
     * Is the list of combo pizzas
     */
    private ArrayList<Pizza> pizzas;
    /**
     * Is the combo image
     */
    private final String comboImageSource;

    /**
     * This is the constructor method.
     *
     * <p>
     *     Initializes the combo name, pizzas list, extras list and combo image with the params inserted.
     * </p>
     *
     * @param comboName Is of type string.
     * @param pizzas Is of type ArrayList.
     */
    public Combo(String comboName, ArrayList<Pizza> pizzas, ArrayList<Extra> extras, String comboImageSource) {
        this.comboName = comboName;
        this.pizzas = pizzas;
        this.extras = extras;
        this.comboImageSource = comboImageSource;
        comboPrice = calculatePrice();
    }

    /**
     * This is a getter method of the combo name.
     *
     * @return Returns a String type.
     */
    public String getComboName() {
        return comboName;
    }

    /**
     * This is a setter method of the combo name.
     *
     * @param comboName Is of type string.
     */
    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    /**
     * This is a getter method of the combo price.
     *
     * @return Returns a double type.
     */
    public double getComboPrice() {
        return comboPrice;
    }

    /**
     * This is a setter method of the combo price.
     *
     * @param comboPrice Is of type double.
     */
    public void setComboPrice(double comboPrice) {
        this.comboPrice = comboPrice;
    }

    /**
     * This is a getter method of the combo products.
     *
     * @return Returns a ArrayList type.
     */
    public ArrayList<Pizza> getPizzasList() {
        return pizzas;
    }

    /**
     * This is a setter method of the combo products.
     *
     * @param pizzas Is of type ArrayList.
     */
    public void setPizzasList(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    /**
     * This is a getter method of the extras list.
     *
     * @return Returns a list of extras.
     */
    public ArrayList<Extra> getExtrasList() {
        return extras;
    }

    /**
     * This is a setter method of the extras list.
     *
     * @param extras Is of type ArrayList
     */
    public void setExtrasList(ArrayList<Extra> extras) {
        this.extras = extras;
    }

    /**
     * This is a getter method of combo image.
     *
     * @return Returns a String with the image link.
     */
    public String getComboImageSource() {
        return comboImageSource;
    }

    /**
     * This is a method to add pizzas to combo.
     *
     * @param pizza Is of type pizza.
     */
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    /**
     * This method calculated the combo price.
     *
     * <p>
     *     Calculate the price of the combo with a 6% discount.
     * </p>
     */
    private double calculatePrice(){
        MediumPizza mediumPizza = new MediumPizza();
        Portion450gr portion450gr = new Portion450gr();
        Litters2 litters2 = new Litters2();

        for(Pizza pizza : pizzas){
            comboPrice += mediumPizza.getPriceSize(pizza.getIngredients());
        }
        for(Extra extra : extras){
            if(extra.getClass() == ExtraServingOfDesserts.class){
                comboPrice += portion450gr.getPriceSize(((ExtraServingOfDesserts) extra).getListOfIngredients());
            }
            if(extra.getClass() == ExtraDrink.class){
                comboPrice += litters2.getPriceQuantity();
            }
        }
        return comboPrice * 0.94;
    }
}
