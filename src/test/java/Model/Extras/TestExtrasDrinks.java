package Model.Extras;

import com.example.pizasson.DataBase.DBExtraDrinks;
import com.example.pizasson.Model.Extras.ExtraDrink;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExtrasDrinks {

    DBExtraDrinks dbExtraDrinks = new DBExtraDrinks();

    @Test
    public void testGetPredefinedExtraDrinkName(){
        ExtraDrink extraDrink = dbExtraDrinks.toastDrink;
        assertEquals("Tostada Drink", extraDrink.getName());
    }

    @Test
    public void testGetPredefinedExtraDrinkPrice(){
        ExtraDrink extraDrink = dbExtraDrinks.toastDrink;
        assertEquals(0, extraDrink.getCost());
    }

    @Test
    public void testGetPredefinedTypeExtraDrink(){
        ExtraDrink extraDrink = dbExtraDrinks.toastDrink;
        assertEquals("Juice", extraDrink.getTypeOfDrink());
    }

    @Test
    public void testSetPredefinedExtraDrinkPrice(){
        ExtraDrink extraDrink = dbExtraDrinks.toastDrink;
        extraDrink.setCost(45);
        assertEquals(45, extraDrink.getCost());
    }

    @Test
    public void testSetPredefinedTypeExtraDrink(){
        ExtraDrink extraDrink = dbExtraDrinks.toastDrink;
        extraDrink.setTypeOfDrink("Soda");
        assertEquals("Soda", extraDrink.getTypeOfDrink());
    }
}
