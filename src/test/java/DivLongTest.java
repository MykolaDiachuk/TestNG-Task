import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.tat.module4.Calculator;

public class DivLongTest {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
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
    public Object[][] provideData() {
        return new Object[][] {
                {10L, 2L, 5L},
                {100L, 10L, 10L},
                {-9L, -3L, 3L},
                {0L, 1L, 0L},
                {Long.MAX_VALUE, 1L, Long.MAX_VALUE},
                {Long.MIN_VALUE, -1L, Long.MIN_VALUE},
        };
    }
}
