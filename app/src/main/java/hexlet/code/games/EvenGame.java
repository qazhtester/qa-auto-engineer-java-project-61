package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

import static hexlet.code.RandomUtils.getRandomInt;

public final class EvenGame {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int TOTAL_ROUNDS = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final String IS_EVEN_ANSWER = "yes";
    private static final String NOT_EVEN_ANSWER = "no";

    private EvenGame() {
    }

    public static void run(Scanner scanner, String username) {
        String[][] gameData = createGameData();
        Engine.runGame(scanner, RULES, username, gameData);
    }

    private static String[][] createGameData() {
        String[][] gameData = new String[TOTAL_ROUNDS][2];

        for (int i = 0; i < TOTAL_ROUNDS; i++) {
            int number = getRandomInt(MIN_NUMBER, MAX_NUMBER);
            String question = String.valueOf(number);
            String answer = getCorrectAnswer(number);
            gameData[i][0] = question;
            gameData[i][1] = answer;
        }
        return gameData;
    }

    private static String getCorrectAnswer(int number) {
        return number % 2 == 0 ? IS_EVEN_ANSWER : NOT_EVEN_ANSWER;
    }
}
