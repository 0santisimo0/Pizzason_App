package com.example.pizasson.Model.Extras.ExtraMealSize;

import com.example.pizasson.Model.Extras.ExtrasSizable;
import com.example.pizasson.Model.Extras.ExtraIngredients;
import java.util.ArrayList;

/**
 * This class will be used to manage the economic portion size for the extra products implements the interface
 * ExtraMealSizeable to apply Open Closed principle.
 *
 * @see ExtraMealSizable
 * @author Jefersson Coronel
 */
public class EconomicPortion implements ExtrasSizable {

    /**
     * This method implement of interface ExtraDessertSizable will be used to manage the Economic portion size price for the extra
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
        price *= 2;
        return price;
    }

    /**
     * This is method implement of interface ExtraDessert to gets the names of the extra meal product size option
     * @return the meal size name
     */
    @Override
    public String getSizeName() {
        return "Economic Portion";
    }
}
