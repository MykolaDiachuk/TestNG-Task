import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtTest {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "sqrtData")
    public void testSqrt(double a, double expected) {
        if (Double.isNaN(expected)) {
            Assertions.assertThat(calculator.sqrt(a)).isNaN()
                    .describedAs("Sqrt of a negative number must be NaN");
        } else {
            Assertions.assertThat(calculator.sqrt(a)).isEqualTo(expected, Assertions.offset(0.00001));
        }
    }

    @DataProvider(name = "sqrtData")
    public Object[][] provideData() {
        return new Object[][] {
                {4.0, 2.0},        // sqrt(4) = 2
                {9.0, 3.0},        // sqrt(9) = 3
                {16.0, 4.0},       // sqrt(16) = 4
                {-4.0, Double.NaN}, // sqrt(|-4|) => NaN, because sqrt with negative number is impossible
                {0.0, 0.0},        // sqrt(0) = 0
                {25.0, 5.0},       // sqrt(25) = 5
                {-9.0, Double.NaN}  // sqrt(|-9|) => NaN, because sqrt with negative number is impossible
        };
    }
}
