import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SumLongTest {
    private Calculator calculator;


    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "sumLongData")
    public void testSumLongNumbers(long a, long b, long expected) {
        Assertions.assertThat(calculator.sum(a, b)).isEqualTo(expected);
    }

    @DataProvider(name = "sumLongData")
    public Object[][] provideData() {
        return new Object[][] {
                {1L, 2L, 3L},
                {5L, 5L, 10L},
                {-3L, -7L, -10L},
                {0L, 0L, 0L}
        };
    }
}
