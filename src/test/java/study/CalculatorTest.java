package study;

import calculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator=new Calculator();
    }
    @Test
    void testCalculator(){
        assertEquals(10, calculator.calculate("2 + 3 * 4 / 2"));
    }
    @AfterEach
    public void tearDown(){
        calculator = null;
    }
}
