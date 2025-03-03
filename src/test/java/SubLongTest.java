import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubLongTest {
    private Calculator calculator;


    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "subLongData")
    public void testSubLongNumbers(long a, long b, long expected) {
        Assertions.assertThat(calculator.sub(a, b)).isEqualTo(expected);
    }

    @DataProvider(name = "subLongData")
    public Object[][] provideData() {
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

}
