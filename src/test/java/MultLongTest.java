import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultLongTest {
    private Calculator calculator;


    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "multLongData")
    public void testMultLongNumbers(long a, long b, long expected) {
        Assertions.assertThat(calculator.mult(a, b)).isEqualTo(expected);
    }
    @Test(dataProvider = "multLongOverflowData")
    public void testMultLongOverflow(long a, long b) {
        // Перевіряємо переповнення при множенні великих чисел
        Assertions.assertThatThrownBy(() -> calculator.mult(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("overflow").describedAs("An overflow should occur");
    }
    @DataProvider(name = "multLongData")
    public Object[][] provideData() {
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
                {Long.MAX_VALUE, Long.MAX_VALUE},    // Перевищення верхнього ліміту
                {Long.MIN_VALUE, Long.MIN_VALUE},    // Перевищення нижнього ліміту
                {Long.MAX_VALUE, 2L},                // Перевищення верхнього ліміту
                {Long.MIN_VALUE, -2L}                // Перевищення нижнього ліміту
        };
    }

}
