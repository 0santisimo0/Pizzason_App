package Model.pizza;

import com.example.pizasson.DataBase.DBPredefinedPizzasIngredients;
import com.example.pizasson.Model.pizza.PizzaIngredients;
import com.example.pizasson.Model.pizza.PredefinedPizza;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPredefinedPizza {
    @Test
    public void testGetImageSource(){
        PredefinedPizza predefinedPizza = new PredefinedPizza(
                new DBPredefinedPizzasIngredients().hawaianaIngredients, "Hawaiana",
                "src/main/resources/images/predefinedPizzas/pizzaHawaiana.jpg"
        );
        assertEquals(
            "src/main/resources/images/predefinedPizzas/pizzaHawaiana.jpg", predefinedPizza.getImageSource()
        );
    }

    @Test
    public void testGetPizzaName(){
        PredefinedPizza predefinedPizza = new PredefinedPizza(
                new DBPredefinedPizzasIngredients().hawaianaIngredients, "Hawaiana",
                "src/main/resources/images/predefinedPizzas/pizzaHawaiana.jpg"
        );
        assertEquals("Hawaiana", predefinedPizza.getName());
    }

    @Test
    public void testGetPizzaIngredients(){
        ArrayList<PizzaIngredients> hawainaIngredients = new ArrayList<>(List.of(PizzaIngredients.PINEAPPLE,
                PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.HAM, PizzaIngredients.TOMATO_SAUCE,
                PizzaIngredients.CORN));

        PredefinedPizza predefinedPizza = new PredefinedPizza(
                hawainaIngredients, "Hawaiana",
                "src/main/resources/images/predefinedPizzas/pizzaHawaiana.jpg"
        );
        assertEquals(5, predefinedPizza.getIngredients().size());
    }
}
