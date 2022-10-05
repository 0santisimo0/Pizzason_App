package com.example.pizasson.Model.Extras;

import com.example.pizasson.Model.Extras.ExtraMealSize.AcademicPortion;
import com.example.pizasson.Model.Extras.ExtraMealSize.EconomicPortion;
import com.example.pizasson.Model.Extras.ExtraMealSize.LargePortion;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is inherits from the extra parent class and implements new required attributes of the class.
 *
 */
public class ExtraMealPortion extends Extra {
    private ArrayList<ExtraIngredients> listOfIngredients = new ArrayList<>();

    /**
     * This is a constructor of class ExtraMealPortion will be assigned values when we use this constructor.
     *
     * @param name is used to put the name when use the constructor.
     * @param listOfIngredients is used to put the list of attributes.
     */
    public ExtraMealPortion(String name, ArrayList<ExtraIngredients> listOfIngredients) {
        super(name);
        this.listOfIngredients = listOfIngredients;
    }

    /**
     * This method gets an ArrayList with the extra meals sizes options.
     *
     * @return sizes meal names.
     */
    public ArrayList<ExtrasSizable> getMealSizes(){
        return new ArrayList<>(List.of(new AcademicPortion(), new EconomicPortion(), new LargePortion()));
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
