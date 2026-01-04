package hexlet.code.games;


import hexlet.code.Engine;

import java.util.Scanner;

import static hexlet.code.RandomUtils.getRandomInt;

public final class ProgressionGame {
    private static final String RULES = "What number is missing in the progression?";
    private static final int TOTAL_ROUNDS = 3;
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MIN_START_NUMBER = 1;
    private static final int MAX_START_NUMBER = 20;
    private static final int MIN_STEP = 2;
    private static final int MAX_STEP = 9;

    private ProgressionGame() {
    }

    public static void run(Scanner scanner, String username) {
        String[][] gameData = createGameData();
        Engine.runGame(scanner, RULES, username, gameData);
    }

    private static String[][] createGameData() {
        String[][] gameData = new String[TOTAL_ROUNDS][2];

        for (int i = 0; i < TOTAL_ROUNDS; i++) {
            int sequenceLength = getRandomInt(MIN_LENGTH, MAX_LENGTH);
            int startNumber = getRandomInt(MIN_START_NUMBER, MAX_START_NUMBER);
            int step = getRandomInt(MIN_STEP, MAX_STEP);
            int missingPosition = getRandomInt(sequenceLength - 1);

            String question = buildQuestion(sequenceLength, missingPosition, startNumber, step);
            String answer = String.valueOf(startNumber + missingPosition * step);

            gameData[i][0] = question;
            gameData[i][1] = answer;
        }

        return gameData;
    }

    private static String buildQuestion(int sequenceLength,
                                        int missingPosition,
                                        int startNumber,
                                        int step) {
        StringBuilder question = new StringBuilder();
        for (int i = 0; i < sequenceLength; i++) {
            if (i == missingPosition) {
                question.append("..");
            } else {
                question.append(startNumber + i * step);
            }

            if (i < sequenceLength - 1) {
                question.append(" ");
            }
        }

        return question.toString();
    }
}
