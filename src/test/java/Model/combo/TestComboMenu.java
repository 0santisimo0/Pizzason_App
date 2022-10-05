package Model.combo;
import com.example.pizasson.DataBase.DBCombos;
import com.example.pizasson.Model.CombosMenu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestComboMenu {
    CombosMenu combosMenu = new CombosMenu(new DBCombos().combos);

    @Test
    public void testCombosNumber() {
        assertEquals(6,combosMenu.getCombos().size());
    }

    @Test
    public void testOrderedCombosNumber() {
        assertEquals(0, combosMenu.getCombosOrderedNumber());
    }
}
