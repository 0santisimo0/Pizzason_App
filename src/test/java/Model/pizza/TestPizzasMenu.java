package Model.pizza;

import com.example.pizasson.DataBase.DBMenu;
import com.example.pizasson.Model.pizza.PizzasMenu;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class    TestPizzasMenu {
    @Test
    public void testInitialPizzasOrderedNumber(){
        PizzasMenu pizzasMenu = new PizzasMenu(new DBMenu().predefinedPizzas);
        assertEquals(0, pizzasMenu.getPizzasOrderedNumber());
    }

    @Test
    public void testSetPizzasOrderedNumber(){
        PizzasMenu pizzasMenu = new PizzasMenu(new DBMenu().predefinedPizzas);
        pizzasMenu.setPizzasOrderedNumber(5);
        assertEquals(5, pizzasMenu.getPizzasOrderedNumber());
    }

    @Test
    public void testGetPredefinedPizzas(){
        PizzasMenu pizzasMenu = new PizzasMenu(new DBMenu().predefinedPizzas);
        assertEquals(6, pizzasMenu.getPredefinedPizzas().size());
    }

    @Test
    public void testAddOnePizzaOrdered(){
        PizzasMenu pizzasMenu = new PizzasMenu(new DBMenu().predefinedPizzas);

        pizzasMenu.addOnePizzaOrdered(1);
        pizzasMenu.addOnePizzaOrdered(1);
        pizzasMenu.addOnePizzaOrdered(1);

        assertEquals(3, pizzasMenu.getPizzasOrderedNumber());
    }

    @Test
    public void testGetPizzaSizes(){
        PizzasMenu pizzasMenu = new PizzasMenu(new DBMenu().predefinedPizzas);
        assertEquals(3, pizzasMenu.getPizzaSizes().size());
    }
}
