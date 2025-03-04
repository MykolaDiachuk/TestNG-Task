import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "multDoubleData")
    public void testMultDoubleNumbers(double a, double b, double expected) {
        Assertions.assertThat(calculator.mult(a, b)).isEqualTo(expected);
    }
    @Test(dataProvider = "multDoubleDataException")
    public void testMultDoubleExceptions(double a, double b) {
        Assertions.assertThatThrownBy(() -> calculator.mult(a, b))
                .isInstanceOf(ArithmeticException.class)
                .describedAs("Multiplying by NaN and infinity should throw an ArithmeticException");
    }

    @Test(dataProvider = "multLongData")
    public void testMultLongNumbers(long a, long b, long expected) {
        Assertions.assertThat(calculator.mult(a, b)).isEqualTo(expected);
    }

    @Test(dataProvider = "multLongOverflowData")
    public void testMultLongOverflow(long a, long b) {
        Assertions.assertThatThrownBy(() -> calculator.mult(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("overflow").describedAs("An overflow should occur");
    }
    @DataProvider(name = "multLongData")
    public Object[][] provideDataForLong() {
        return new Object[][] {
                {5L, 2L, 10L},
                {10L, 5L, 50L},
                {-3L, -7L, 21L},
                {0L, 0L, 0L},
                {100L, 50L, 5000L},
                {-10L, 5L, -50L},
                {Long.MAX_VALUE, 1L, Long.MAX_VALUE},
                {Long.MIN_VALUE, -1L, Long.MIN_VALUE * -1}
        };
    }

    @DataProvider(name = "multLongOverflowData")
    public Object[][] provideOverflowData() {
        return new Object[][] {
                {Long.MAX_VALUE, Long.MAX_VALUE},    // Exceeding the upper limit
                {Long.MIN_VALUE, Long.MIN_VALUE},    // Exceeding the upper limit
                {Long.MAX_VALUE, 2L},                // Exceeding the upper limit
                {Long.MIN_VALUE, -2L}                // Exceeding the upper limit
        };
    }

    @DataProvider(name = "multDoubleData")
    public Object[][] provideDataForDouble() {
        return new Object[][] {
                {5.5, 2.2, Math.floor(5.5 * 2.2)},
                {10.3, 5.1, Math.floor(10.3 * 5.1)},
                {-3.7, -7.4, Math.floor(-3.7 * -7.4)},
                {0.0, 0.0, 0.0},
                {100.9, 50.5, Math.floor(100.9 * 50.5)},
                {-10.2, 5.3, Math.floor(-10.2 * 5.3)},
                {Double.MAX_VALUE, 0.5, Math.floor(Double.MAX_VALUE * 0.5)},
                {Double.MIN_VALUE, 2.0, Math.floor(Double.MIN_VALUE * 2.0)}
        };
    }

    @DataProvider(name = "multDoubleDataException")
    public Object[][] provideDataForExceptions() {
        return new Object[][] {
                {Double.POSITIVE_INFINITY, 0.0},  // multiplication by infinity
                {0.0, Double.POSITIVE_INFINITY},  // multiplication by infinity
                {Double.NaN, 100.0},              // multiplication by NaN
                {100.0, Double.NaN}              // multiplication by NaN
        };
    }
}
