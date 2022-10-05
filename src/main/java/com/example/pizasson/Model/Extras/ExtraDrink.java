package com.example.pizasson.Model.Extras;

import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.ExtraDrinkQuantity;
import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.Litters2;
import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.PersonalDrink;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is inherits from the extra parent class and implements new required attributes of the class.
 *
 */
public class ExtraDrink extends Extra {
    private String typeOfDrink;;

    /**
     * This method is a constructor where we will be assigned values when we use this constructor.
     *
     * @param name is used to put the name when use the constructor.
     * @param typeOfDrink is used to put the cost when use the constructor.
     */
    public ExtraDrink(String name, String typeOfDrink) {
        super(name);
        this.typeOfDrink = typeOfDrink;
    }

    /**
     * This method gets an ArrayList with the extra drinks quantities options.
     *
     * @return quantities names.
     */
    public ArrayList<ExtraDrinkQuantity> getDrinkQuantity(){
        return new ArrayList<>(List.of(new Litters2(), new Litters2(), new PersonalDrink()));
    }

    /**
     * This method return the type of Drink when we call the method.
     *
     * @return getTypeOfDrink to get when is required.
     */
    public String getTypeOfDrink() {
        return typeOfDrink;
    }

    /**
     * This method set typeOfDrink when we can change the value of param.
     *
     * @param typeOfDrink This param will be change when the method is called.
     */
    public void setTypeOfDrink(String typeOfDrink) {
        this.typeOfDrink = typeOfDrink;
    }
}
