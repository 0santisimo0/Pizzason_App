package Model.Extras;

import com.example.pizasson.DataBase.DBExtraDrinks;
import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.ExtraDrinkQuantity;
import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.Litters2;
import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.Litters3;
import com.example.pizasson.Model.Extras.ExtraDrinkQuantity.PersonalDrink;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExtraDrinkQuantity {

    DBExtraDrinks dbExtraDrinks = new DBExtraDrinks();

    @Test
    public void testGet2littersPrice() {
        ExtraDrinkQuantity drinkQuantity2litters = new Litters2();
        assertEquals(4, drinkQuantity2litters.getPriceQuantity());
    }

    @Test
    public void testGet3littersPrice() {
        ExtraDrinkQuantity drinkQuantity3litters = new Litters3();
        assertEquals(6, drinkQuantity3litters.getPriceQuantity());
    }

    @Test
    public void testGet3littersName() {
        ExtraDrinkQuantity drinkQuantity3litters = new Litters3();
        assertEquals("3 Litters", drinkQuantity3litters.getQuantityName());
    }

    @Test
    public void testGet2littersName() {
        ExtraDrinkQuantity drinkQuantity2litters = new Litters2();
        assertEquals("2 Litters", drinkQuantity2litters.getQuantityName());
    }

    @Test
    public void testGetPersonalLittersPrice() {
        ExtraDrinkQuantity extraDrinkQuantityPersonal = new PersonalDrink();
        assertEquals(2, extraDrinkQuantityPersonal.getPriceQuantity());
    }

}
