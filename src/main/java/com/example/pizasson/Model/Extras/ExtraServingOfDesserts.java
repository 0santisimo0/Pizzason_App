package com.example.pizasson.Model.Extras;

import com.example.pizasson.Model.Extras.ExtraDessertsSize.Portion100gr;
import com.example.pizasson.Model.Extras.ExtraDessertsSize.Portion1300gr;
import com.example.pizasson.Model.Extras.ExtraDessertsSize.Portion450gr;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is inherits from the extra parent class and implements new required attributes of the class.
 *
 */
public class ExtraServingOfDesserts extends Extra {
    private String typeOfDessert;
    private ArrayList<ExtraIngredients> listOfIngredients = new ArrayList<>();

    /**
     * This is a constructor of class ExtraMealPortion will be assigned values when we use this constructor.
     *
     * @param name is used to put the name when use the constructor.
     * @param typeOfDessert is used to put the type of dessert.
     * @param listOfIngredients is used to put the list of attributes.
     */
    public ExtraServingOfDesserts(String name, String typeOfDessert, ArrayList<ExtraIngredients> listOfIngredients) {
        super(name);
        this.typeOfDessert = typeOfDessert;
        this.listOfIngredients = listOfIngredients;
    }

    /**
     * This method gets an ArrayList with the extra desserts sizes options.
     *
     * @return sizes dessert names.
     */
    public ArrayList<ExtrasSizable> getDessertsSize(){
        return new ArrayList<>(List.of(new Portion100gr(), new Portion450gr(), new Portion1300gr()));
    }

    /**
     * This method return the type of Dessert when we call the method.
     *
     * @return typeOfDessert to get when is required.
     */
    public String getTypeOfDessert() {
        return typeOfDessert;
    }

    /**
     * This method set typeOfDessert when we can change the value of param.
     *
     * @param typeOfDessert This param will be change when the method is called.
     */
    public void setTypeOfDessert(String typeOfDessert) {
        this.typeOfDessert = typeOfDessert;
    }

    /**
    * This method gets an ArrayList with the extra meals ingredients.
    *
    * @return list of ingredients of each element.
    */
    public ArrayList<ExtraIngredients> getListOfIngredients() {
        return listOfIngredients;
    }
}
