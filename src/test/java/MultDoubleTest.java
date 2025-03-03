import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultDoubleTest {
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

    @DataProvider(name = "multDoubleData")
    public Object[][] provideData() {
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
                {Double.POSITIVE_INFINITY, 0.0},  // множення на нескінченність
                {0.0, Double.POSITIVE_INFINITY},  // множення на нескінченність
                {Double.NaN, 100.0},              // множення на NaN
                {100.0, Double.NaN}               // множення на NaN
        };
    }
}
