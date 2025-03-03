import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowTest {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "powData")
    public void testPow(double a, double b, double expected) {
        Assertions.assertThat(calculator.pow(a, b)).isEqualTo(expected, Assertions.offset(0.001));
    }

    @DataProvider(name = "powData")
    public Object[][] provideData() {
        return new Object[][] {
                {2.0, 3.0, 8.0}, // 2^3 = 8
                {5.0, 2.0, 25.0}, // 5^2 = 25
                {3.0, -1.0, 0.3333}, // 3^-1 ≈ 0.3333
                {10.0, 0.0, 1.0}, // 10^0 = 1
                {2.0, 1.5, 2.8284}, // 2^1.5 ≈ 2.8284 but Math.floor(1.5) == 1,then 2^1 = 2
                {4.0, -2.0, 0.0625} // 4^-2 = 0.0625
        };
    }
}
