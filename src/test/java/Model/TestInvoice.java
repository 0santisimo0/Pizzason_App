package Model;

import com.example.pizasson.Model.Client;
import com.example.pizasson.Model.Invoice;
import com.example.pizasson.Model.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInvoice {
    private static Client client;
    private static Invoice invoice;

    @BeforeAll
    public static void init(){
        client = new Client("Jefersson", "123123123", "jeffthekiller@gmail.com");
        invoice = new Invoice(client, new ArrayList<>(List.of(
                new Order("pizza", "hawaiana", 3, 40)
        )));
    }
    @Test
    public void testClientNameInvoice(){
        String clientName = client.getName();
        assertEquals("Jefersson", clientName);
    }

    @Test
    public void testClientNitInvoice(){
        String clientNit = client.getNit();
        assertEquals("123123123", clientNit);
    }

    @Test
    public void testClientEmailInvoice(){
        String clientEmail = client.getEmail();
        assertEquals("jeffthekiller@gmail.com", clientEmail);
    }

    @Test
    public void testSetGetInvoiceId() {
        invoice.setInvoiceId(12345);
        assertEquals(12345, invoice.getInvoiceID());
    }

    @Test
    public void testSetGetOrders() {
        invoice.setOrders(new ArrayList<>(List.of(
                new Order("pizza", "hawaiana", 3, 40)
        )));
        assertEquals(1, invoice.getOrders().size());
    }
}
