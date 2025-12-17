package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;
import static hexlet.code.RandomUtils.getRandomInt;

public final class GcdGame extends Game {
    private static final int MIN_NUMBER = 2;
    private static final int MAX_DIVISOR_NUMBER = 15;
    private static final int MAX_NUMBER = 100;
    private int firstNumber;
    private int secondNumber;

    public GcdGame(Scanner scanner, String username) {
        super(scanner, username);
    }

    @Override
    protected void printRules() {
        print("Find the greatest common divisor of given numbers.");
    }

    @Override
    protected String generateQuestion() {
        int baseDivisor = getRandomInt(MIN_NUMBER, MAX_DIVISOR_NUMBER);

        //Генерация двух чисел < 100, кратных baseDivisor
        firstNumber = baseDivisor * getRandomInt(MIN_NUMBER, MAX_NUMBER / baseDivisor);
        secondNumber = baseDivisor * getRandomInt(MIN_NUMBER, MAX_NUMBER / baseDivisor);

        return firstNumber + " " + secondNumber;
    }

    @Override
    protected String getCorrectAnswer() {
        int correctAnswer = getGcd(firstNumber, secondNumber);
        return String.valueOf(correctAnswer);
    }

    private int getGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
