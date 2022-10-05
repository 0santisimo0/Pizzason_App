package com.example.pizasson.DataBase;

import com.example.pizasson.Model.Extras.ExtraMealPortion;
import java.util.ArrayList;
import java.util.List;

public class DBExtraMeal {
    DBIngredientsOfExtras dbIngredientsOfExtras = new DBIngredientsOfExtras();

    public ExtraMealPortion salad = new ExtraMealPortion("Salad", dbIngredientsOfExtras.saladIngredients);

    public ExtraMealPortion CheeseSticks = new ExtraMealPortion("Cheese Sticks",
            dbIngredientsOfExtras.CheeseSticksIngredients);

    public ExtraMealPortion potatoChips = new ExtraMealPortion("Potato Chips",
            dbIngredientsOfExtras.potatoChipsIngredients);

    public ExtraMealPortion ChickenWings = new ExtraMealPortion("Chicken Wings",
            dbIngredientsOfExtras.ChickenWingsIngredients);

    public ArrayList<ExtraMealPortion> listOfMeal = new ArrayList<>(List.of(CheeseSticks, salad, ChickenWings,
            potatoChips));

}
