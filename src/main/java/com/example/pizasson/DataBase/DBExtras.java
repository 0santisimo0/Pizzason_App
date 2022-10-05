package com.example.pizasson.DataBase;
import java.util.ArrayList;
import java.util.List;


public class DBExtras {
    DBExtraDesserts dbExtraDesserts = new DBExtraDesserts();
    DBExtraDrinks dbExtraDrinks = new DBExtraDrinks();
    DBExtraMeal dbExtraMeal = new DBExtraMeal();

    public ArrayList<ArrayList> listOfExtras = new ArrayList<>(List.of(dbExtraDesserts.listDesserts,
            dbExtraDrinks.listOfDrinks, dbExtraMeal.listOfMeal));







}
