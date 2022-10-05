package com.example.pizasson.DataBase;

import com.example.pizasson.Model.Extras.ExtraIngredients;
import java.util.ArrayList;
import java.util.List;

public class DBIngredientsOfExtras {

    //DESSERTS
    public ArrayList<ExtraIngredients> genoeseIngredients = new ArrayList<>(List.of(ExtraIngredients.EGG,
            ExtraIngredients.CREAM_OF_TARTAR, ExtraIngredients.BUTTER_SOFTENED, ExtraIngredients.SIFTED_CAKE_FLOUR));

    public ArrayList<ExtraIngredients> babaIngredients = new ArrayList<>(List.of(ExtraIngredients.EGGPLANT,
            ExtraIngredients.GARLIC, ExtraIngredients.LEMON_JUICE, ExtraIngredients.VEGETABLE_OIL,
            ExtraIngredients.TAHINI, ExtraIngredients.GROUND_CUMIN, ExtraIngredients.GROUND_PAPRIKA));

    public ArrayList<ExtraIngredients> biscuitIngredients = new ArrayList<>(List.of(ExtraIngredients.FLOUR,
            ExtraIngredients.BUTTER, ExtraIngredients.CREAM_OF_TARTAR, ExtraIngredients.MILK));

    public ArrayList<ExtraIngredients> lemonPaiIngredients = new ArrayList<>(List.of(ExtraIngredients.EGG,
            ExtraIngredients.SIFTED_CAKE_FLOUR, ExtraIngredients.LEMON_JUICE, ExtraIngredients.VEGETABLE_OIL));

    public ArrayList<ExtraIngredients> puddingIngredients = new ArrayList<>(List.of(ExtraIngredients.BUTTER,
            ExtraIngredients.BUTTER_SOFTENED, ExtraIngredients.MILK, ExtraIngredients.VANILLA));

    public ArrayList<ExtraIngredients> saltedPumpkinFlanIngredients = new ArrayList<>(List.of(
            ExtraIngredients.GROUND_GINGER, ExtraIngredients.PUMPKIN_PUREE, ExtraIngredients.EGG,
            ExtraIngredients.VANILLA));

    //MEAL
    public ArrayList<ExtraIngredients> saladIngredients = new ArrayList<>(List.of(ExtraIngredients.EGG,
            ExtraIngredients.ONIONS, ExtraIngredients.LETTUCE, ExtraIngredients.TOMATO, ExtraIngredients.POTATO,
            ExtraIngredients.PEPPER, ExtraIngredients.CARROT));

    public ArrayList<ExtraIngredients> CheeseSticksIngredients = new ArrayList<>(List.of(ExtraIngredients.EGG,
            ExtraIngredients.BREAD, ExtraIngredients.GARLIC, ExtraIngredients.FLOUR,
            ExtraIngredients.MOZZARELLA_CHEESE));

    public ArrayList<ExtraIngredients> potatoChipsIngredients = new ArrayList<>(List.of(ExtraIngredients.VEGETABLE_OIL,
            ExtraIngredients.POTATO, ExtraIngredients.BUTTER_SOFTENED));

    public ArrayList<ExtraIngredients> ChickenWingsIngredients = new ArrayList<>(List.of(ExtraIngredients.GROUND_PAPRIKA,
            ExtraIngredients.FLOUR, ExtraIngredients.PEPPER, ExtraIngredients.CHICKEN_WINGS, ExtraIngredients.HOT_SAUCE,
            ExtraIngredients.BLACK_PEPPER, ExtraIngredients.GARLIC, ExtraIngredients.BUTTER));

}
