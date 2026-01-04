package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

import static hexlet.code.RandomUtils.getRandomInt;

public final class CalcGame {
    private static final String RULES = "What is the result of the expression?";
    private static final int TOTAL_ROUNDS = 3;
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 50;
    private static final char[] OPERATORS = {'+', '-', '*'};

    private CalcGame() {
    }

    public static void run(Scanner scanner, String username) {
        String[][] gameData = createGameData();
        Engine.runGame(scanner, RULES, username, gameData);
    }

    private static String[][] createGameData() {
        String[][] gameData = new String[TOTAL_ROUNDS][2];

        for (int i = 0; i < TOTAL_ROUNDS; i++) {
            int firstOperand = getRandomInt(MIN_NUMBER, MAX_NUMBER);
            int secondOperand = getRandomInt(MIN_NUMBER, MAX_NUMBER);
            char currentOperation = OPERATORS[getRandomInt(OPERATORS.length - 1)];

            String question = firstOperand + " " + currentOperation + " " + secondOperand;
            String answer = getCorrectAnswer(firstOperand, secondOperand, currentOperation);

            gameData[i][0] = question;
            gameData[i][1] = answer;
        }
        return gameData;
    }

    private static String getCorrectAnswer(int firstOperand, int secondOperand, char currentOperation) {
        return switch (currentOperation) {
            case '+' -> String.valueOf(firstOperand + secondOperand);
            case '-' -> String.valueOf(firstOperand - secondOperand);
            case '*' -> String.valueOf(firstOperand * secondOperand);
            default -> throw new IllegalArgumentException("Unknown operator: " + currentOperation);
        };
    }
}
