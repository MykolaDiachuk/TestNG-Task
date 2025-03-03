import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignTest {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    // DataProvider for isPositive() method
    @DataProvider(name = "positiveData")
    public Object[][] positiveData() {
        return new Object[][] {
                {5L, true},
                {0L, false},
                {-3L, false},
                {Long.MAX_VALUE, true},
                {Long.MIN_VALUE, false}
        };
    }

    @Test(dataProvider = "positiveData")
    public void testIsPositive(long input, boolean expected) {
        boolean result = calculator.isPositive(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    // DataProvider for isNegative() method
    @DataProvider(name = "negativeData")
    public Object[][] negativeData() {
        return new Object[][] {
                {5L, false},
                {0L, false},
                {-3L, true},
                {Long.MAX_VALUE, false},
                {Long.MIN_VALUE, true}
        };
    }

    @Test(dataProvider = "negativeData")
    public void testIsNegative(long input, boolean expected) {
        boolean result = calculator.isNegative(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
