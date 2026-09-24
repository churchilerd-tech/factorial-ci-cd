import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    @Test
    public void testFactorial() {
        assertEquals(120, Factorial.calculate(5));
    }

    @Test
    public void testZeroFactorial() {
        assertEquals(1, Factorial.calculate(0));
    }

    @Test
    public void testOneFactorial() {
        assertEquals(1, Factorial.calculate(1));
    }
}