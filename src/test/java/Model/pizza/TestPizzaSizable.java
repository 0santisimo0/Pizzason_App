package Model.pizza;

import com.example.pizasson.Model.pizza.PizzaIngredients;
import com.example.pizasson.Model.pizza.pizzaSizes.FamiliarPizza;
import com.example.pizasson.Model.pizza.pizzaSizes.MediumPizza;
import com.example.pizasson.Model.pizza.pizzaSizes.PizzaSizable;
import com.example.pizasson.Model.pizza.pizzaSizes.SmallPizza;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPizzaSizable {
    @Test
    public void testGetFamiliarPrice(){
        PizzaSizable familiarPizza = new FamiliarPizza();
        ArrayList<PizzaIngredients> hawaianaIngredients = new ArrayList<>(List.of(PizzaIngredients.PINEAPPLE,
                PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.HAM, PizzaIngredients.TOMATO_SAUCE, PizzaIngredients.CORN));
        assertEquals(123.5, familiarPizza.getPriceSize(hawaianaIngredients));
    }

    @Test
    public void testGetFamiliarName(){
        PizzaSizable familiarPizza = new FamiliarPizza();
        assertEquals("Familiar", familiarPizza.getSizeName());
    }

    @Test
    public void testGetMediumPrice(){
        PizzaSizable mediumPizza = new MediumPizza();
        ArrayList<PizzaIngredients> hawaianaIngredients = new ArrayList<>(List.of(PizzaIngredients.PINEAPPLE,
                PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.HAM, PizzaIngredients.TOMATO_SAUCE, PizzaIngredients.CORN));
        assertEquals(57.0, mediumPizza.getPriceSize(hawaianaIngredients));
    }

    @Test
    public void testGetMediumName(){
        PizzaSizable mediumPizza = new MediumPizza();
        assertEquals("Medium", mediumPizza.getSizeName());
    }

    @Test
    public void testGetSmallPrice(){
        PizzaSizable smallPizza = new SmallPizza();
        ArrayList<PizzaIngredients> hawaianaIngredients = new ArrayList<>(List.of(PizzaIngredients.PINEAPPLE,
                PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.HAM, PizzaIngredients.TOMATO_SAUCE, PizzaIngredients.CORN));
        assertEquals(28.5, smallPizza.getPriceSize(hawaianaIngredients));
    }

    @Test
    public void testGetSmallName(){
        PizzaSizable smallPizza = new SmallPizza();
        assertEquals("Small", smallPizza.getSizeName());
    }
}
