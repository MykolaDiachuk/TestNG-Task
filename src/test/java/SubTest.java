import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubTest {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "subDoubleData")
    public void testSubDoubleNumbers(double a, double b, double expected) {
        Assertions.assertThat(calculator.sub(a, b)).isEqualTo(expected);
    }

    @Test(dataProvider = "subLongData")
    public void testSubLongNumbers(long a, long b, long expected) {
        Assertions.assertThat(calculator.sub(a, b)).isEqualTo(expected);
    }

    @DataProvider(name = "subLongData")
    public Object[][] provideDataForLong() {
        return new Object[][] {
                {5L, 2L, 3L},
                {10L, 5L, 5L},
                {-3L, -7L, 4L},
                {0L, 0L, 0L},
                {100L, 50L, 50L},
                {-10L, 5L, -15L},
                {Long.MAX_VALUE, 1L, Long.MAX_VALUE - 1},
                {Long.MIN_VALUE, -1L, Long.MIN_VALUE + 1}
        };
    }
    @DataProvider(name = "subDoubleData")
    public Object[][] provideDataForDouble() {
        return new Object[][] {
                {5.5, 2.2, 3.3},
                {10.0, 5.5, 4.5},
                {-3.7, -7.2, 3.5},
                {0.0, 0.0, 0.0},
                {100.1, 50.05, 50.05},
                {-10.5, 5.5, -16.0},
                {Double.MAX_VALUE, 1.0, Double.MAX_VALUE - 1},
                {Double.MIN_VALUE, -1.0, Double.MIN_VALUE + 1}
        };
    }

}
