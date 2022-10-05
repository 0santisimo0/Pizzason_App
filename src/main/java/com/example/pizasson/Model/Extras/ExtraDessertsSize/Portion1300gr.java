package com.example.pizasson.Model.Extras.ExtraDessertsSize;

import com.example.pizasson.Model.Extras.ExtraIngredients;
import com.example.pizasson.Model.Extras.ExtrasSizable;

import java.util.ArrayList;

/**
 * This class will be used to manage the 1130 gr portion size for the extra products implements the interface
 * ExtraDessertSizable to apply Open Closed principle.
 *
 * @see ExtrasSizable
 */
public class Portion1300gr implements ExtrasSizable {

    /**
     * This method implement of interface ExtraDessertSizable will be used to manage the 1300 gr portion size price for the extra
     * products to apply Open Closed principle.
     *
     * @param extraIngredients This attribute is used to calculate the price with the extra ingredients.
     * @return price of extra product.
     */
    @Override
    public double getPriceSize(ArrayList<ExtraIngredients> extraIngredients) {
        double price = 0;
        for (ExtraIngredients extraIngredient :extraIngredients){
            price = extraIngredient.getCost() + price;
        }
        price *= 4.4;
        return price;
    }

    /**
     * This is method implement of interface ExtraDessert to gets the names of the extra dessert product size option
     * @return the Dessert size name
     */
    @Override
    public String getSizeName() {
        return "1300 gr. Portion";
    }
}
