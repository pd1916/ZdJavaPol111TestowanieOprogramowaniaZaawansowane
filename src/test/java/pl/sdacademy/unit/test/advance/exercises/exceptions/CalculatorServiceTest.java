package pl.sdacademy.unit.test.advance.exercises.exceptions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    /*
        null, 1
        1, null
        null, null
     */
    @ParameterizedTest
    @MethodSource("provideData")
    void shouldThrowExceptionWhenAnyOfArgumentIsNull(String firstDigit, String secondDigit) {
        //when & then
        assertThrows(IllegalArgumentException.class, () -> CalculatorService.add(firstDigit, secondDigit)); //jUnit
        assertThatThrownBy(() -> CalculatorService.add(firstDigit, secondDigit)) //assertJ
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Arguments 'a' and 'b' are required.");
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(null, "1"),
                Arguments.of("1", null),
                Arguments.of(null, null)
        );
    }
}