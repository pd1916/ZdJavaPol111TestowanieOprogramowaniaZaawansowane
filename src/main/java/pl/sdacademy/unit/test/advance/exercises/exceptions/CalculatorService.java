package pl.sdacademy.unit.test.advance.exercises.exceptions;

public class CalculatorService {
    // todo dodajcie walidację żeby można było przekazywać Stringi z któtych da się zrobić liczby
    public static int add(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments 'a' and 'b' are required.");
        }
        return Math.addExact(Integer.parseInt(a), Integer.parseInt(b));
    }
}
