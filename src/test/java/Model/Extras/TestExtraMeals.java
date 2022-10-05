package Model.Extras;

import com.example.pizasson.DataBase.DBExtraMeal;;
import com.example.pizasson.Model.Extras.ExtraIngredients;
import com.example.pizasson.Model.Extras.ExtraMealPortion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExtraMeals {

    DBExtraMeal dbExtraMeal = new DBExtraMeal();

    @Test
    public void testGetPredefinedExtraMealName(){
        ExtraMealPortion extraMeal = dbExtraMeal.ChickenWings;
        assertEquals("Chicken Wings", extraMeal.getName());
    }

    @Test
    public void testGetNumberOfIngredientsInExtraMeal(){
        ExtraMealPortion extraMeal = dbExtraMeal.ChickenWings;
        assertEquals(8, extraMeal.getListOfIngredients().size());
    }

    @Test
    public void testGetNumberAddIngredientsInExtraMeal(){
        ExtraMealPortion extraMeal = dbExtraMeal.ChickenWings;
        extraMeal.getListOfIngredients().add(ExtraIngredients.LETTUCE);
        assertEquals(9, extraMeal.getListOfIngredients().size());
    }

    @Test
    public void testSetPredefinedExtraMealCost(){
        ExtraMealPortion extraMeal = dbExtraMeal.ChickenWings;
        extraMeal.setCost(55);
        assertEquals(55, extraMeal.getCost());
    }
}
