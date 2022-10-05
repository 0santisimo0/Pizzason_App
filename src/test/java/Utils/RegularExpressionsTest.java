package Utils;

import com.example.pizasson.utils.RegularExpression;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegularExpressionsTest {
    @Test
    public void testLettersValidation() {
        String word = "Santiago";
        assertFalse(RegularExpression.getRegularExpression().validateLetters(word));
    }
    @Test
    public void testNumbersValidation() {
        String number = "93434534";
        assertFalse(RegularExpression.getRegularExpression().validateNumbers(number));
    }
    @Test
    public void testEmailValidation() {
        String email = "santicm95386b@gmail.com";
        assertTrue(RegularExpression.getRegularExpression().validateEmail(email));
    }
}
