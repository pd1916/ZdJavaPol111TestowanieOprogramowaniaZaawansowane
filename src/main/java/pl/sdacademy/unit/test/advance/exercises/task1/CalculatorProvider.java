package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorProvider {

    static Stream<Arguments> provideDataForAdd() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(2, -4, -2),
                Arguments.of(-5, 6, 1)
        );
    }
}
