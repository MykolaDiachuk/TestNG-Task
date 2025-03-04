import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "divDoubleData")
    public void testDivDoubleNumbers(double a, double b, double expected) {
        Assertions.assertThat(calculator.div(a, b))
                .isCloseTo(expected, Assertions.offset(0.001));
    }

    @Test(dataProvider = "divDoubleDataException")
    public void testDivDoubleException(double a, double b) {
        try {
            calculator.div(a, b);
        } catch (ArithmeticException e) {
            Assertions.assertThat(e).hasMessage("Attempt to divide by zero");
        }
    }

    @Test(dataProvider = "divLongData")
    public void testDivLongNumbers(long a, long b, long expected) {
        if (b == 0) {
            Assertions.assertThatThrownBy(() -> calculator.div(a, b))
                    .isInstanceOf(NumberFormatException.class)
                    .hasMessage("Attempt to divide by zero");
        } else {
            Assertions.assertThat(calculator.div(a, b)).isEqualTo(expected);
        }
    }

    @DataProvider(name = "divLongData")
    public Object[][] provideDataForLong() {
        return new Object[][] {
                {10L, 2L, 5L},
                {100L, 10L, 10L},
                {-9L, -3L, 3L},
                {0L, 1L, 0L},
                {Long.MAX_VALUE, 1L, Long.MAX_VALUE},
                {Long.MIN_VALUE, -1L, Long.MIN_VALUE},
        };
    }

    @DataProvider(name = "divDoubleData")
    public Object[][] provideDataForDouble() {
        return new Object[][]{
                {10.0, 2.0, 5.0},
                {100.5, 10.1, 9.95},
                {-9.0, -3.0, 3.0},
                {0.0, 1.0, 0.0},
                {Double.MAX_VALUE, 1.0, Double.MAX_VALUE},
                {Double.MIN_VALUE, -1.0, -Double.MIN_VALUE},
                {1.0, 0.0, Double.POSITIVE_INFINITY}
        };
    }

    @DataProvider(name = "divDoubleDataException")
    public Object[][] provideDataForExceptions() {
        return new Object[][]{
                {1.0, 0.0},    // division by zero
                {0.0, 0.0},    // division by zero
                {Double.POSITIVE_INFINITY, 0.0}, // infinity divided by zero
                {Double.NaN, 0.0} // NaN divided by zero
        };
    }
}
