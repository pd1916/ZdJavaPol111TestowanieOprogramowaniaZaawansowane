package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    //package.NazwaKlasy#nazwaMetody
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.task1.CalculatorProvider#provideDataForAdd")
    void shouldReturnAddTwoValues(int firstDigit, int secondDigit, int expectedResult) {
        //when
        int result = calculator.add(firstDigit, secondDigit);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void shouldThrowExceptionWhenSecondDigitIsZero(){
        //given
        int firstDigit = 5;
        int secondDigit = 0;
        //when & then
        assertThatThrownBy(() -> calculator.divide(firstDigit, secondDigit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Can't divide by 0");
    }
}