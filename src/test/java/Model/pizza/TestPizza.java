package Model.pizza;

import com.example.pizasson.Model.pizza.Pizza;
import com.example.pizasson.Model.pizza.PizzaIngredients;
import com.example.pizasson.Model.pizza.pizzaSizes.PizzaSizable;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPizza {

    @Test
    public void testGetPizzaIngredients(){
        ArrayList<PizzaIngredients> ingredientsChoosen = new ArrayList<>(List.of(PizzaIngredients.PINEAPPLE,
                PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.HAM, PizzaIngredients.TOMATO_SAUCE,
                PizzaIngredients.CORN));

        Pizza personalizedPizza = new Pizza("Personalized Pizza",ingredientsChoosen);
        assertEquals(5, personalizedPizza.getIngredients().size());
    }

    @Test
    public void testGetPizzaSizesNames() {
        ArrayList<PizzaIngredients> ingredientsChoosen = new ArrayList<>(List.of(PizzaIngredients.PINEAPPLE,
                PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.HAM, PizzaIngredients.TOMATO_SAUCE,
                PizzaIngredients.CORN));
        Pizza personalizedPizza = new Pizza("Personalized Pizza",ingredientsChoosen);

        StringBuilder sizesNames = new StringBuilder();

        for (PizzaSizable size: personalizedPizza.getPizzaSizes()) {
            sizesNames.append(size.getSizeName()).append(" ");
        }

        assertEquals("Small Medium Familiar ", sizesNames.toString());
    }

    @Test
    public void testGetPizzaPriceDependingTheSize() {
        ArrayList<PizzaIngredients> ingredientsChoosen = new ArrayList<>(List.of(PizzaIngredients.PINEAPPLE,
                PizzaIngredients.MOZZARELLA_CHEESE, PizzaIngredients.HAM));

        Pizza personalizedPizza = new Pizza("Personalized Pizza");
        StringBuilder sizesNames = new StringBuilder();

        for (PizzaSizable size: personalizedPizza.getPizzaSizes()) {
            sizesNames.append(size.getSizeName()).append(": ").append(size.getPriceSize(ingredientsChoosen)).append(" ");
        }

        assertEquals("Small: 18.0 Medium: 36.0 Familiar: 78.0 ", sizesNames.toString());
    }
}
