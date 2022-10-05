package Model.combo;

import com.example.pizasson.DataBase.DBOrders;
import com.example.pizasson.Model.Combo;
import com.example.pizasson.Model.Extras.Extra;
import com.example.pizasson.Model.Order;
import com.example.pizasson.Model.pizza.Pizza;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class TestCounter {
    ArrayList<Pizza> pizzas = new ArrayList<>();
    ArrayList<Extra> extras = new ArrayList<>();
    Combo combo = new Combo("Combo Test", pizzas, extras, " ");
    DBOrders dbOrders = new DBOrders();
    @Test
    public void test(){
        Order order = new Order(combo.getComboName(), " ", 1, 10);
        Order order2 = new Order(combo.getComboName(), " ", 1, 43);
        Order order3 = new Order(combo.getComboName(), " ", 1, 67);

        dbOrders.combosOrders.add(order);
        dbOrders.combosOrders.add(order2);
        dbOrders.combosOrders.add(order3);

        assertEquals(3, dbOrders.combosOrders.size());
    }
}
