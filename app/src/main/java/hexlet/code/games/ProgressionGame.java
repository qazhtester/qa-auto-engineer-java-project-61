package hexlet.code.games;


import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;
import static hexlet.code.RandomUtils.getRandomInt;

public final class ProgressionGame extends Game {
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MIN_START_NUMBER = 1;
    private static final int MAX_START_NUMBER = 20;
    private static final int MIN_STEP = 2;
    private static final int MAX_STEP = 9;
    private int startNumber;
    private int missingPosition;
    private int step;

    public ProgressionGame(Scanner scanner, String username) {
        super(scanner, username);
    }

    @Override
    protected void printRules() {
        print("What number is missing in the progression?");
    }

    @Override
    protected String generateQuestion() {
        int sequenceLength = getRandomInt(MIN_LENGTH, MAX_LENGTH);
        startNumber = getRandomInt(MIN_START_NUMBER, MAX_START_NUMBER);
        step = getRandomInt(MIN_STEP, MAX_STEP);
        missingPosition = getRandomInt(sequenceLength - 1);

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

    @Override
    protected String getCorrectAnswer() {
        return String.valueOf(startNumber + missingPosition * step);
    }
}
