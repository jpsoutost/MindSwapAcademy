import academy.mindswap.wtfjunit.Calculator;
import academy.mindswap.wtfjunit.OtherClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.security.InvalidParameterException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorTests {

    private Calculator calculator;
    @Mock
    private OtherClass otherClass;

    @BeforeEach
    public void setup(){
        this.calculator = new Calculator(otherClass);
    }

    @Test
    public void test_getNewReference_shouldRockHellYeah(){
        //GIVEN
        Integer length = 7;
        when(otherClass.getRandomNumbers(anyInt())).thenReturn(List.of(4,6,7,8,9,2,4));

        //WHEN
        String result = calculator.getNewReference(length);

        //THEN
        String expected = "4678924";
        assertEquals(length, result.length(),"Reference length");
        assertEquals(expected, result,"Reference value");

        verify(otherClass, times(1)).printReference(anyString());
    }

    @Test
    public void test_sumTwoValidNumbers_shouldReturnResult(){
        //GIVEN
        Integer n1 = 3;
        Integer n2 = 2;

        //WHEN
        Integer result = calculator.sumTwoNumbers(n1, n2);

        //THEN
        Integer expected = 5;
        assertEquals(expected,result);
    }

    @Test
    public void test_sumNullWithValidNumber_shouldReturnException(){
        //GIVEN
        Integer n1 = null;
        Integer n2 = 2;

        //WHEN
        Executable action = () -> calculator.sumTwoNumbers(n1,n2);

        //THEN
        assertThrows(InvalidParameterException.class,action);
    }

    @Test
    public void test_sumNulls_shouldReturnException(){
        //GIVEN
        Integer n1 = null;
        Integer n2 = null;

        //WHEN
        Executable action = () -> calculator.sumTwoNumbers(n1,n2);

        //THEN
        assertThrows(InvalidParameterException.class,action);
    }

    /*@Test
    public void test_sumNullWithValidNumber_shouldReturnNumberNotNuLL(){
        //GIVEN
        Integer n1 = null;
        Integer n2 = 2;

        //WHEN
        Integer result = calculator.sumTwoNumbers(n1, n2);

        //THEN
        Integer expected = 2;
        assertEquals(expected,result);
    }

    @Test
    public void test_sumNulls_shouldReturnZero(){
        //GIVEN
        Integer n1 = null;
        Integer n2 = null;

        //WHEN
        Integer result = calculator.sumTwoNumbers(n1, n2);

        //THEN
        Integer expected = 0;
        assertEquals(expected,result);
    }*/
}
