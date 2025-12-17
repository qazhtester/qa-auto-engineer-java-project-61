package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;
import static hexlet.code.RandomUtils.getRandomInt;

public final class CalcGame extends Game {
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 50;
    private static final char[] OPERATORS = {'+', '-', '*'};
    private int firstOperand;
    private int secondOperand;
    private char currentOperation;

    public CalcGame(Scanner scanner, String username) {
        super(scanner, username);
    }

    @Override
    protected void printRules() {
        print("What is the result of the expression?");
    }

    @Override
    protected String generateQuestion() {
        firstOperand = getRandomInt(MIN_NUMBER, MAX_NUMBER);
        secondOperand = getRandomInt(MIN_NUMBER, MAX_NUMBER);
        currentOperation = OPERATORS[getRandomInt(OPERATORS.length - 1)];
        return firstOperand + " " + currentOperation + " " + secondOperand;
    }

    @Override
    protected String getCorrectAnswer() {
        return switch (currentOperation) {
            case '+' -> String.valueOf(firstOperand + secondOperand);
            case '-' -> String.valueOf(firstOperand - secondOperand);
            case '*' -> String.valueOf(firstOperand * secondOperand);
            default -> throw new IllegalArgumentException("Unknown operator: " + currentOperation);
        };
    }
}
