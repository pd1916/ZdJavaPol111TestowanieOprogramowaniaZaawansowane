package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    /*
            -1, ?
            max_integer, ?
            0, 0
            1, 1
            4, 3
            6, 8
     */
    @ParameterizedTest
    @MethodSource("provideData")
    void shouldReturnCorrectValue(int input, int expectedResult) {
        //when
        int result = Fibonacci.getValueFromIndex(input);
        //then
        assertEquals(expectedResult, result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(4, 3),
                Arguments.of(6, 8)
                // Arguments.of(-1, 0) //todo naprawić metodę żeby test przechodził, i dodać więcej testów na liczby ujemne
        );
    }

}