package com.example.pizasson.Model.Extras.ExtraDrinkQuantity;

/**
 * This class will be used to manage the 0.750 litters quantity for the extra products implements the interface
 * ExtraDrinkQuantity to apply Open Closed principle.
 *
 * @see ExtraDrinkQuantity
 */
public class PersonalDrink implements ExtraDrinkQuantity {

    /**
     * This method implements of interface ExtraDrinkQuantity will be used to manage the 0.750 litters quantity price
     * for the extra products to apply Open Closed principle.
     *
     * @return price of extra drink product.
     */
    @Override
    public double getPriceQuantity() {
        return  2;
    }


    /**
     * This is method implement of interface ExtraDrinkQuantity to gets the names of the extra drink product quantity
     * option in this case is 0.750 litters.
     *
     * @return the extra drinks products quantity name
     */
    @Override
    public String getQuantityName() {
        return "0.750 Litters";
    }
}
