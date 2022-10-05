package com.example.pizasson.Model.Extras.ExtraMealSize;

import com.example.pizasson.Model.Extras.ExtrasSizable;
import com.example.pizasson.Model.Extras.ExtraIngredients;

import java.util.ArrayList;

/**
 * This class will be used to manage the large portion size for the extra products implements the interface
 * ExtraMealSizeable to apply Open Closed principle.
 *
 * @see ExtraMealSizable
 * @author Jefersson Coronel
 */
public class LargePortion implements ExtrasSizable {

    /**
     * This method implement of interface ExtraDessertSizable will be used to manage the Large portion size price for the extra
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
        price *= 4.5;
        return price;
    }

    /**
     * This is method implement of interface ExtraDessert to gets the names of the extra meal product size option
     * @return the meal size name
     */
    @Override
    public String getSizeName() {
        return "Large Portion";
    }
}
