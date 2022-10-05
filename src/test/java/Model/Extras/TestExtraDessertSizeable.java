package Model.Extras;

import com.example.pizasson.DataBase.DBIngredientsOfExtras;
import com.example.pizasson.Model.Extras.ExtrasSizable;
import com.example.pizasson.Model.Extras.ExtraDessertsSize.Portion100gr;
import com.example.pizasson.Model.Extras.ExtraDessertsSize.Portion1300gr;
import com.example.pizasson.Model.Extras.ExtraDessertsSize.Portion450gr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExtraDessertSizeable {

    DBIngredientsOfExtras dbIngredientsOfExtras = new DBIngredientsOfExtras();

    @Test
    public void testGetPortion1300grPrice() {
            ExtrasSizable extraDessert1300gr= new Portion1300gr();
        assertEquals(103, Math.round(extraDessert1300gr.getPriceSize(dbIngredientsOfExtras.babaIngredients)));
    }

    @Test
    public void testGetPortion450grPrice() {
        ExtrasSizable extraDessert450gr= new Portion450gr();
        assertEquals(35, Math.round(extraDessert450gr.getPriceSize(dbIngredientsOfExtras.babaIngredients)));
    }

    @Test
    public void testGetPortion100grPrice() {
        ExtrasSizable extraDessert100gr= new Portion100gr();
        assertEquals(7, Math.round(extraDessert100gr.getPriceSize(dbIngredientsOfExtras.babaIngredients)));
    }

    @Test
    public void testGetPortion1300grName() {
        ExtrasSizable extraDessert1300gr= new Portion1300gr();
        assertEquals("1300 gr. Portion", extraDessert1300gr.getSizeName());
    }

    @Test
    public void testGetPortion450grName() {
        ExtrasSizable extraDessert450gr= new Portion450gr();
        assertEquals("450 gr. Portion", extraDessert450gr.getSizeName());
    }

    @Test
    public void testGetPortion100grName() {
        ExtrasSizable extraDessert100gr= new Portion100gr();
        assertEquals("One Portion 100 gr", extraDessert100gr.getSizeName());
    }
}
