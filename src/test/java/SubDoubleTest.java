import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubDoubleTest {
    private Calculator calculator;


    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "subDoubleData")
    public void testSubDoubleNumbers(double a, double b, double expected) {
        Assertions.assertThat(calculator.sub(a, b)).isEqualTo(expected);
    }

    @DataProvider(name = "subDoubleData")
    public Object[][] provideData() {
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
