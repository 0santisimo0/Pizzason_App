package Model;

import com.example.pizasson.DataBase.ModifyOrders;
import com.example.pizasson.Model.Client;
import com.example.pizasson.Model.Invoice;
import com.example.pizasson.Model.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestModifyOrders {
    private static ModifyOrders modifyOrders;

    @BeforeAll
    public static void init(){
        modifyOrders = new ModifyOrders();
    }
    @Test
    public void testSetGetOrders(){
        modifyOrders.setOrders(new ArrayList<>(
            List.of(
                    new Order("Title", "description", 2, 40),
                    new Order("Title", "description", 2, 40),
                    new Order("Title", "description", 2, 40)
            )
        ));
        assertEquals(3, modifyOrders.getOrders().size());
    }
}
