package com.example.pizasson.Model.Extras;

import com.example.pizasson.Model.Extras.ExtraIngredients;
import java.util.ArrayList;

/**
 * This interface ExtraDessertSizeable is used to apply open closed.
 *
 */
public interface ExtrasSizable {

    /**
     * This method is used to get the extra product size price depending on the ingredients and the size.
     *
     * @param extraIngredients the price is increment depending on the products of extra.
     */
    double getPriceSize(ArrayList<ExtraIngredients> extraIngredients);

    /**
     * This method is used to get the extra dessert size name
     */
    String getSizeName();
}
