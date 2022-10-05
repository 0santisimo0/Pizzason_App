package Model.Extras;

import com.example.pizasson.DataBase.DBExtraDesserts;
import com.example.pizasson.Model.Extras.ExtraIngredients;
import com.example.pizasson.Model.Extras.ExtraServingOfDesserts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExtraDessert {
    DBExtraDesserts dbExtraDesserts = new DBExtraDesserts();

    @Test
    public void testGetPredefinedExtraDessertName(){
        ExtraServingOfDesserts extraDesserts = dbExtraDesserts.baba;
        assertEquals("Baba", extraDesserts.getName());
    }

    @Test
    public void testGetTypeOfExtraDessert(){
        ExtraServingOfDesserts extraDesserts = dbExtraDesserts.baba;
        assertEquals("Sweet", extraDesserts.getTypeOfDessert());;
    }

    @Test
    public void testGetNumberOfIngredientsInExtraDessert(){
        ExtraServingOfDesserts extraDessert = dbExtraDesserts.baba;
        assertEquals(7, extraDessert.getListOfIngredients().size());

    }

    @Test
    public void testGetNumberAddIngredientsInExtraMeal(){
        ExtraServingOfDesserts extraDessert = dbExtraDesserts.baba;
        extraDessert.getListOfIngredients().add(ExtraIngredients.FLOUR);
        assertEquals(8, extraDessert.getListOfIngredients().size());
    }

    @Test
    public void testSetPredefinedExtraDessertCost(){
        ExtraServingOfDesserts extraDessert = dbExtraDesserts.baba;
        extraDessert.setCost(55);
        assertEquals(55, extraDessert.getCost());
    }

    @Test
    public void testSetTypeExtraDessert(){
        ExtraServingOfDesserts extraDessert = dbExtraDesserts.baba;
        extraDessert.setTypeOfDessert("Salad");
        assertEquals("Salad", extraDessert.getTypeOfDessert());
    }
}
