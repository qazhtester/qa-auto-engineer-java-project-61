package hexlet.code.games;

import java.util.List;

import static hexlet.code.RandomUtils.getRandomInt;

public final class CalcGame {
    public static final String RULES = "What is the result of the expression?";
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 50;
    private static final char[] OPERATORS = {'+', '-', '*'};

    private CalcGame() {
    }

    public static List<String> getTask() {
        int firstOperand = getRandomInt(MIN_NUMBER, MAX_NUMBER);
        int secondOperand = getRandomInt(MIN_NUMBER, MAX_NUMBER);
        char currentOperation = OPERATORS[getRandomInt(OPERATORS.length - 1)];
        String question = firstOperand + " " + currentOperation + " " + secondOperand;
        String answer = getCorrectAnswer(firstOperand, secondOperand, currentOperation);
        return List.of(question, answer);
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
