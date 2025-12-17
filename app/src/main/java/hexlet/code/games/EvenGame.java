package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;
import static hexlet.code.RandomUtils.getRandomInt;

public final class EvenGame extends Game {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final String IS_EVEN_ANSWER = "yes";
    private static final String NOT_EVEN_ANSWER = "no";
    private int number;

    public EvenGame(Scanner scanner, String username) {
        super(scanner, username);
    }

    @Override
    protected void printRules() {
        print("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    @Override
    protected String generateQuestion() {
        number = getRandomInt(MIN_NUMBER, MAX_NUMBER);
        return String.valueOf(number);
    }

    @Override
    protected String getCorrectAnswer() {
        return number % 2 == 0 ? IS_EVEN_ANSWER : NOT_EVEN_ANSWER;
    }
}
