import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }


    @Test
    public void testSum() {
        int result = calculator.add(1, 2);

        int expected = 3;

        assertEquals(expected, result);

        System.out.println("Test Sum: " + result + " Excepted: " + expected);
    }

    @Test
    public void testSub() {
        int result = calculator.add(1, 1);

        int expected = 2;

        assertEquals(expected, result);

        System.out.println("Test Sub: " + result + " Excepted: " + expected);

    }

}
