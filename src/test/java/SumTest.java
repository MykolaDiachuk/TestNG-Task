import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "sumDoubleData")
    public void testSumDoubleNumbers(double a, double b, double expected) {
        Assertions.assertThat(calculator.sum(a, b)).isEqualTo(expected);
    }

    @Test(dataProvider = "sumLongData")
    public void testSumLongNumbers(long a, long b, long expected) {
        Assertions.assertThat(calculator.sum(a, b)).isEqualTo(expected);
    }

    @DataProvider(name = "sumLongData")
    public Object[][] provideDataForLong() {
        return new Object[][] {
                {1L, 2L, 3L},
                {5L, 5L, 10L},
                {-3L, -7L, -10L},
                {0L, 0L, 0L}
        };
    }
    @DataProvider(name = "sumDoubleData")
    public Object[][] provideDataForDouble() {
        return new Object[][] {
                {1.5, 2.3, 3.8},
                {5.0, 5.0, 10.0},
                {-3.7, -7.2, -10.9},
                {0.0, 0.0, 0.0},
                {2.5, -1.5, 1.0},
                {1000000.1, 0.9, 1000001.0}
        };
    }
}
