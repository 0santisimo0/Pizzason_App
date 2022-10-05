package Model;

import com.example.pizasson.Model.HomeOrder;
import com.example.pizasson.Model.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHomeOrder {
    @Test
    public void testSetGetOrders(){
        ArrayList<Order> orders = new ArrayList<>(List.of(new Order(
                "Order title", "Description", 20, 3.0
        )));
        HomeOrder homeOrder = new HomeOrder();
        homeOrder.setOrders(orders);
        assertEquals(1, homeOrder.getOrders().size());
    }

    @Test
    public void testSetGetPizzasOrderedNumber(){
        HomeOrder homeOrder = new HomeOrder();
        homeOrder.setPizzasOrderedNumber(4);
        assertEquals(4, homeOrder.getPizzasOrderedNumber());
    }

    @Test
    public void testSetGetPizzasBuiltNumber(){
        HomeOrder homeOrder = new HomeOrder();
        homeOrder.setPizzasBuiltNumber(10);
        assertEquals(10, homeOrder.getPizzasBuiltNumber());
    }

    @Test
    public void testSetGetCombosOrderedNumber(){
        HomeOrder homeOrder = new HomeOrder();
        homeOrder.setCombosOrderedNumber(3);
        assertEquals(3, homeOrder.getCombosOrderedNumber());
    }

    @Test
    public void testSetGetExtrasOrderedNumber(){
        HomeOrder homeOrder = new HomeOrder();
        homeOrder.setExtrasOrderedNumber(7);
        assertEquals(7, homeOrder.getExtrasOrderedNumber());
    }

    @Test
    public void testIncreaseOnePizzasOrderedNumber(){
        HomeOrder homeOrder = new HomeOrder();
        homeOrder.setPizzasOrderedNumber(6);

        homeOrder.increaseOnePizzaOrdered();
        homeOrder.increaseOnePizzaOrdered();
        homeOrder.increaseOnePizzaOrdered();
        homeOrder.increaseOnePizzaOrdered();

        assertEquals(10, homeOrder.getPizzasOrderedNumber());
    }

    @Test
    public void testIncreaseOnePizzasBuiltNumber(){
        HomeOrder homeOrder = new HomeOrder();
        homeOrder.setPizzasBuiltNumber(2);
        homeOrder.increaseOnePizzaBuilt();

        assertEquals(3, homeOrder.getPizzasBuiltNumber());
    }

    @Test
    public void testIncreaseOneCombosOrderedNumber(){
        HomeOrder homeOrder = new HomeOrder();
        homeOrder.setCombosOrderedNumber(2);

        homeOrder.increaseOneComboOrdered();
        homeOrder.increaseOneComboOrdered();
        homeOrder.increaseOneComboOrdered();


        assertEquals(5, homeOrder.getCombosOrderedNumber());
    }

    @Test
    public void testIncreaseOneExtrasOrderedNumber(){
        HomeOrder homeOrder = new HomeOrder();
        homeOrder.setExtrasOrderedNumber(2);

        homeOrder.increaseOneExtraOrdered();
        homeOrder.increaseOneExtraOrdered();

        assertEquals(4, homeOrder.getExtrasOrderedNumber());
    }

    @Test
    public void testHomeOrderConstructor(){
        ArrayList<Order> orders = new ArrayList<>(List.of(new Order(
                "Order title", "Description", 3, 20.0
        )));
        HomeOrder homeOrder = new HomeOrder(
                orders,3,4,5,6
        );
        assertEquals(
                1, homeOrder.getOrders().size()
        );
        assertEquals(3, homeOrder.getPizzasOrderedNumber());
        assertEquals(4, homeOrder.getPizzasBuiltNumber());
        assertEquals(5, homeOrder.getCombosOrderedNumber());
        assertEquals(6, homeOrder.getExtrasOrderedNumber());
    }
}
