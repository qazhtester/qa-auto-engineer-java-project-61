package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;
import static hexlet.code.RandomUtils.getRandomInt;

public final class PrimeGame extends Game {
    private static final String IS_PRIME_ANSWER = "yes";
    private static final String NOT_PRIME_ANSWER = "no";
    private static final int MAX_NUMBER = 100;
    private static final int FIRST_PRIME = 2;
    private static final int START_CHECK_DIVISOR = 3;
    private int number;

    public PrimeGame(Scanner scanner, String username) {
        super(scanner, username);
    }

    @Override
    protected void printRules() {
        print("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    @Override
    protected String generateQuestion() {
        number = getRandomInt(MAX_NUMBER);
        return String.valueOf(number);
    }

    @Override
    protected String getCorrectAnswer() {
        return isPrime() ? IS_PRIME_ANSWER : NOT_PRIME_ANSWER;
    }

    private boolean isPrime() {
        if (number == FIRST_PRIME) {
            return true;
        }

        if (number < FIRST_PRIME || number % FIRST_PRIME == 0) {
            return false;
        }

        for (int i = START_CHECK_DIVISOR; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
