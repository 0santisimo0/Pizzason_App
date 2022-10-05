package com.example.pizasson.DataBase;

import com.example.pizasson.Model.Extras.ExtraDrink;

import java.util.ArrayList;
import java.util.List;

public class DBExtraDrinks {
    public ExtraDrink cocaCola = new ExtraDrink("Coca Cola Soda", "Soda");
    public ExtraDrink cocaColaZero = new ExtraDrink("Coca Cola Zero ", "light");
    public ExtraDrink spriteSoda = new ExtraDrink("Sprite", "Soda");
    public ExtraDrink fantaSoda = new ExtraDrink("Fanta", "Soda");
    public ExtraDrink sodaWater = new ExtraDrink("Soda Water", "Soda");
    public ExtraDrink toastDrink = new ExtraDrink("Tostada Drink", "Juice");
    public ExtraDrink lemonJuice = new ExtraDrink("Lemon Juice", "Light");

    public ArrayList<ExtraDrink> listOfDrinks = new ArrayList<>(List.of(cocaCola, spriteSoda, cocaColaZero,
            fantaSoda, sodaWater, toastDrink, lemonJuice));
}