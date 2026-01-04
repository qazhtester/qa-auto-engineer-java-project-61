package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

import static hexlet.code.RandomUtils.getRandomInt;

public final class GcdGame {
    public static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int TOTAL_ROUNDS = 3;
    private static final int MIN_NUMBER = 2;
    private static final int MAX_DIVISOR_NUMBER = 15;
    private static final int MAX_NUMBER = 100;

    private GcdGame() {
    }

    public static void run(Scanner scanner, String username) {
        String[][] gameData = createGameData();
        Engine.runGame(scanner, RULES, username, gameData);
    }

    private static String[][] createGameData() {
        String[][] gameData = new String[TOTAL_ROUNDS][2];

        for (int i = 0; i < TOTAL_ROUNDS; i++) {
            int baseDivisor = getRandomInt(MIN_NUMBER, MAX_DIVISOR_NUMBER);

            //Генерация двух чисел < 100, кратных baseDivisor
            int firstNumber = baseDivisor * getRandomInt(MIN_NUMBER, MAX_NUMBER / baseDivisor);
            int secondNumber = baseDivisor * getRandomInt(MIN_NUMBER, MAX_NUMBER / baseDivisor);

            String question = firstNumber + " " + secondNumber;
            String answer = String.valueOf(getGcd(firstNumber, secondNumber));

            gameData[i][0] = question;
            gameData[i][1] = answer;
        }

        return gameData;
    }

    private static int getGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
