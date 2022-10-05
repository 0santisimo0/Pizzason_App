package com.example.pizasson.DataBase;
import com.example.pizasson.Model.Extras.ExtraServingOfDesserts;

import java.util.ArrayList;
import java.util.List;

public class DBExtraDesserts {
    DBIngredientsOfExtras dbIngredientsOfExtras = new DBIngredientsOfExtras();

    public ExtraServingOfDesserts genoese = new ExtraServingOfDesserts("Genoese", "Sweet",
            dbIngredientsOfExtras.genoeseIngredients);

    public ExtraServingOfDesserts baba = new ExtraServingOfDesserts("Baba", "Sweet",
            dbIngredientsOfExtras.babaIngredients);

    public ExtraServingOfDesserts biscuit = new ExtraServingOfDesserts("Biscuit", "Sweet",
            dbIngredientsOfExtras.biscuitIngredients);

    public ExtraServingOfDesserts lemonPie = new ExtraServingOfDesserts("Lemon Pie", "Sweet",
            dbIngredientsOfExtras.lemonPaiIngredients);

    public ExtraServingOfDesserts pudding = new ExtraServingOfDesserts("Pudding", "Sweet",
            dbIngredientsOfExtras.puddingIngredients);

    public ExtraServingOfDesserts saltedPumpkinFlan = new ExtraServingOfDesserts("Salted pumpkin flan",
            "Salty", dbIngredientsOfExtras.saltedPumpkinFlanIngredients);

    public ArrayList<ExtraServingOfDesserts> listDesserts = new ArrayList<>(List.of(genoese, baba, biscuit, lemonPie,
            pudding, saltedPumpkinFlan));
}
