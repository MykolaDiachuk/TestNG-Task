import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.within;

public class TrigonometricTest {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "sinData")
    public Object[][] sinData() {
        return new Object[][]{
                {Math.PI / 2, 1.0},        // sin(π/2) = 1
                {Math.PI, 0.0},            // sin(π) = 0
                {Math.PI / 4, Math.sin(Math.PI / 4)}, // sin(π/4)
        };
    }

    @Test(dataProvider = "sinData")
    public void testSin(double input, double expected) {
        double result = calculator.sin(input);
        Assertions.assertThat(result).isCloseTo(expected, within(0.0001));
    }

    @DataProvider(name = "cosData")
    public Object[][] cosData() {
        return new Object[][]{
                {Math.PI, -1.0},          // cos(π) = -1
                {Math.PI / 2, 0.0},       // cos(π/2) = 0
                {Math.PI / 4, Math.cos(Math.PI / 4)}, // cos(π/4)
        };
    }

    @Test(dataProvider = "cosData")
    public void testCos(double input, double expected) {
        double result = calculator.cos(input);
        Assertions.assertThat(result).isCloseTo(expected, within(0.0001));
    }

    @DataProvider(name = "tgData")
    public Object[][] tgData() {
        return new Object[][]{
                {Math.PI / 4, 1.0},          // tg(π/4) = 1
                {Math.PI / 2, Double.POSITIVE_INFINITY}, // tg(π/2) = ∞
                {Math.PI / 6, Math.tan(Math.PI / 6)}, // tg(π/6)
        };
    }

    @Test(dataProvider = "tgData")
    public void testTg(double input, double expected) {
        double result = calculator.tg(input);
        Assertions.assertThat(result).isCloseTo(expected, within(0.0001));
    }

    @DataProvider(name = "ctgData")
    public Object[][] ctgData() {
        return new Object[][]{
                {Math.PI / 4, 1.0},          // ctg(π/4) = 1
                {Math.PI / 6, 1 / Math.tan(Math.PI / 6)}, // ctg(π/6)
                {Math.PI / 2, 0.0},          // ctg(π/2) = 0
        };
    }

    @Test(dataProvider = "ctgData")
    public void testCtg(double input, double expected) {
        double result = calculator.ctg(input);
        Assertions.assertThat(result).isCloseTo(expected, within(0.0001));
    }
}
