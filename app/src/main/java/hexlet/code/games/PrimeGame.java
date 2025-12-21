package hexlet.code.games;

import java.util.List;

import static hexlet.code.RandomUtils.getRandomInt;

public final class PrimeGame {
    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final String IS_PRIME_ANSWER = "yes";
    private static final String NOT_PRIME_ANSWER = "no";
    private static final int MAX_NUMBER = 100;
    private static final int FIRST_PRIME = 2;
    private static final int START_CHECK_DIVISOR = 3;

    private PrimeGame() {
    }

    public static List<String> getTask() {
        int number = getRandomInt(MAX_NUMBER);
        String correctAnswer = isPrime(number) ? IS_PRIME_ANSWER : NOT_PRIME_ANSWER;
        return List.of(String.valueOf(number), correctAnswer);
    }

    private static boolean isPrime(int number) {
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
