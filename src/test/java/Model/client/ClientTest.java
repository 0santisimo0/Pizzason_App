package Model.client;

import com.example.pizasson.Model.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {
    @Test
    public void getTheClientInformation() {
        Client client = new Client("Santiago","33434","jeffTheKiller@gmail.com");
        assertEquals("Santiago",client.getName());
        assertEquals("33434",client.getNit());
        assertEquals("jeffTheKiller@gmail.com",client.getEmail());
    }
}
