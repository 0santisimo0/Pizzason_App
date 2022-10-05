package com.example.pizasson.DataBase;

import com.example.pizasson.Model.Combo;
import com.example.pizasson.Model.Extras.Extra;
import com.example.pizasson.Model.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;

public class DBCombos {

    DBMenu dbMenu = new DBMenu();
    DBExtras dbExtras = new DBExtras();

    ArrayList<Pizza> pizzasonComboPizzas = new ArrayList<>(List.of(dbMenu.cheesePizza, dbMenu.veganPizza));
    ArrayList<Pizza> bigComboPizzas = new ArrayList<>(List.of(dbMenu.cheesePizza, dbMenu.mexicanPizza, dbMenu.mushroomPizza));
    ArrayList<Pizza> personalComboPizzas = new ArrayList<>(List.of(dbMenu.pepperoniPizza));
    ArrayList<Pizza> familyComboPizzas = new ArrayList<>(List.of(dbMenu.cheesePizza, dbMenu.pepperoniPizza, dbMenu.hawaianaPizza));
    ArrayList<Pizza> comboX3Pizzas = new ArrayList<>(List.of(dbMenu.mushroomPizza, dbMenu.veganPizza, dbMenu.mexicanPizza));
    ArrayList<Pizza> specialComboPizzas = new ArrayList<>(List.of(dbMenu.pepperoniPizza, dbMenu.mushroomPizza));

    ArrayList<Extra> pizzasonComboExtras = new ArrayList<>(List.of(dbExtras.dbExtraDrinks.cocaCola));
    ArrayList<Extra> bigComboExtras = new ArrayList<>(List.of(dbExtras.dbExtraDrinks.toastDrink, dbExtras.dbExtraDrinks.cocaCola, dbExtras.dbExtraDesserts.genoese));
    ArrayList<Extra> personalComboExtras = new ArrayList<>(List.of(dbExtras.dbExtraDrinks.toastDrink, dbExtras.dbExtraDesserts.biscuit));
    ArrayList<Extra> familyComboExtras = new ArrayList<>(List.of(dbExtras.dbExtraDrinks.lemonJuice , dbExtras.dbExtraDrinks.cocaColaZero, dbExtras.dbExtraDesserts.lemonPie));
    ArrayList<Extra> comboX3Extras = new ArrayList<>(List.of(dbExtras.dbExtraDrinks.sodaWater, dbExtras.dbExtraDrinks.spriteSoda));
    ArrayList<Extra> specialComboExtras = new ArrayList<>(List.of(dbExtras.dbExtraDrinks.fantaSoda, dbExtras.dbExtraDrinks.spriteSoda, dbExtras.dbExtraDesserts.genoese, dbExtras.dbExtraDesserts.baba));

    public Combo pizassonCombo = new Combo("Pizasson Combo", pizzasonComboPizzas, pizzasonComboExtras, "src/main/resources/images/combos/pizzasonCombo.jpg");
    public Combo bigCombo = new Combo("Big Combo", bigComboPizzas, bigComboExtras, "src/main/resources/images/combos/bigCombo.jpg");
    public Combo personalCombo = new Combo("Personal Combo", personalComboPizzas, personalComboExtras, "src/main/resources/images/combos/personalCombo.jpg");
    public Combo familyCombo = new Combo("Family Combo", familyComboPizzas, familyComboExtras, "src/main/resources/images/combos/familyCombo.jpg");
    public Combo comboX3 = new Combo("Combo X3", comboX3Pizzas, comboX3Extras, "src/main/resources/images/combos/comboX3.jpg");
    public Combo specialCombo = new Combo("Special Combo", specialComboPizzas, specialComboExtras, "src/main/resources/images/combos/specialCombo.jpg");

    public ArrayList<Combo> combos = new ArrayList<>(List.of(pizassonCombo, bigCombo, personalCombo, familyCombo, comboX3, specialCombo));
}
