package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

import static hexlet.code.RandomUtils.getRandomInt;

public final class PrimeGame {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int TOTAL_ROUNDS = 3;
    private static final String IS_PRIME_ANSWER = "yes";
    private static final String NOT_PRIME_ANSWER = "no";
    private static final int MAX_NUMBER = 100;
    private static final int FIRST_PRIME = 2;
    private static final int START_CHECK_DIVISOR = 3;

    private PrimeGame() {
    }

    public static void run(Scanner scanner, String username) {
        String[][] gameData = createGameData();
        Engine.runGame(scanner, RULES, username, gameData);
    }

    private static String[][] createGameData() {
        String[][] gameData = new String[TOTAL_ROUNDS][2];

        for (int i = 0; i < TOTAL_ROUNDS; i++) {
            int number = getRandomInt(MAX_NUMBER);
            String question = String.valueOf(number);
            String answer = isPrime(number) ? IS_PRIME_ANSWER : NOT_PRIME_ANSWER;

            gameData[i][0] = question;
            gameData[i][1] = answer;
        }

        return gameData;
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
