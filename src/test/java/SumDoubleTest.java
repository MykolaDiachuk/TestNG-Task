import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumDoubleTest {
    private Calculator calculator;


    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "sumDoubleData")
    public void testSumDoubleNumbers(double a, double b, double expected) {
        Assertions.assertThat(calculator.sum(a, b)).isEqualTo(expected);
    }

    @DataProvider(name = "sumDoubleData")
    public Object[][] provideData() {
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
