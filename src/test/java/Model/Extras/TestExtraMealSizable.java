package Model.Extras;

import com.example.pizasson.DataBase.DBIngredientsOfExtras;
import com.example.pizasson.Model.Extras.ExtraMealSize.AcademicPortion;
import com.example.pizasson.Model.Extras.ExtraMealSize.EconomicPortion;
import com.example.pizasson.Model.Extras.ExtraMealSize.LargePortion;
import com.example.pizasson.Model.Extras.ExtrasSizable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExtraMealSizable {

    DBIngredientsOfExtras dbIngredientsOfExtras = new DBIngredientsOfExtras();

    @Test
    public void testGetLargePortionPrice() {
        ExtrasSizable largePortion = new LargePortion();
        assertEquals(216.9, largePortion.getPriceSize(dbIngredientsOfExtras.ChickenWingsIngredients));
    }

    @Test
    public void testGetAcademicPrice() {
        ExtrasSizable AcademicPortion = new AcademicPortion();
        assertEquals(169, Math.round(AcademicPortion.getPriceSize(dbIngredientsOfExtras.ChickenWingsIngredients)));
    }

    @Test
    public void testGetEconomicPrice() {
        ExtrasSizable economicPortion = new EconomicPortion();
        assertEquals(96.4, economicPortion.getPriceSize(dbIngredientsOfExtras.ChickenWingsIngredients));
    }

    @Test
    public void testGetLargePortionName() {
        ExtrasSizable largePortion = new LargePortion();
        assertEquals("Large Portion", largePortion.getSizeName());
    }

    @Test
    public void testGetAcademicName() {
        ExtrasSizable AcademicPortion = new AcademicPortion();
        assertEquals("Academic Portion", AcademicPortion.getSizeName());
    }

    @Test
    public void testGetEconomicName() {
        ExtrasSizable economicPortion = new EconomicPortion();
        assertEquals("Economic Portion", economicPortion.getSizeName());
    }

}
