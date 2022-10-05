package Model.combo;

import com.example.pizasson.DataBase.DBCombos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCombo {
    DBCombos dbCombos = new DBCombos();

    @Test
    public void testPizzasNumberInCombo() {
        assertEquals(2, dbCombos.pizassonCombo.getPizzasList().size());
        assertEquals(3, dbCombos.bigCombo.getPizzasList().size());
        assertEquals(1, dbCombos.personalCombo.getPizzasList().size());
        assertEquals(3, dbCombos.familyCombo.getPizzasList().size());
        assertEquals(3, dbCombos.comboX3.getPizzasList().size());
        assertEquals(2, dbCombos.specialCombo.getPizzasList().size());
    }

    @Test
    public void testComboName() {
        assertEquals("Pizasson Combo", dbCombos.pizassonCombo.getComboName());
        assertEquals("Big Combo", dbCombos.bigCombo.getComboName());
        assertEquals("Personal Combo", dbCombos.personalCombo.getComboName());
        assertEquals("Family Combo", dbCombos.familyCombo.getComboName());
        assertEquals("Combo X3", dbCombos.comboX3.getComboName());
        assertEquals("Special Combo", dbCombos.specialCombo.getComboName());
    }

    @Test
    public void testComboPrice() {
        //DecimalFormat priceFormat = new DecimalFormat("#.00");
        assertEquals(100.11, dbCombos.pizassonCombo.getComboPrice());
        assertEquals(198.81, dbCombos.bigCombo.getComboPrice());
        assertEquals(81.357, dbCombos.personalCombo.getComboPrice());
        assertEquals(186.54299999999998, dbCombos.familyCombo.getComboPrice());
        assertEquals(164.97, dbCombos.comboX3.getComboPrice());
        assertEquals(172.44299999999998, dbCombos.specialCombo.getComboPrice());
    }

    @Test
    public void testGetCombos() {
        assertEquals(6, dbCombos.combos.size());
    }
}
