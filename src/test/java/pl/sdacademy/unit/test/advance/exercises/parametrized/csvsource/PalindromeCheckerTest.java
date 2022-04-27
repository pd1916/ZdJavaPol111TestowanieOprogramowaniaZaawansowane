package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {
    // kajak, kobyla ma maly bok
    // java sda

    @ParameterizedTest
    @CsvSource({
            "kajak, true",
            "kobyla ma maly bok, true",
            "java, false",
            "sda, false"})
    void shouldVerifyIfInputIsPalindrome(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv")
    void shouldVerifyIfInputIsPalindromeUsingFile(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result);
        assertThat(result).isEqualTo(expectedResult);
    }
}