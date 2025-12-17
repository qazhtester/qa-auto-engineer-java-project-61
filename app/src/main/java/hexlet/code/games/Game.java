package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;
import static hexlet.code.ConsolePrinter.printf;

abstract class Game {
    private static final int ROUNDS_TO_WIN = 3;
    private final Scanner inputScanner;
    private final String playerName;

    Game(Scanner scanner, String username) {
        this.inputScanner = scanner;
        this.playerName = username;
    }

    public void run() {
        printRules();
        int correctAnswers = 0;

        while (correctAnswers < ROUNDS_TO_WIN) {
            String question = generateQuestion();
            printQuestion(question);

            String userAnswer = getUserAnswer();
            String correctAnswer = getCorrectAnswer();

            if (correctAnswer.equalsIgnoreCase(userAnswer)) {
                print("Correct!");
                correctAnswers++;
            } else {
                printWrongAnswerMessage(userAnswer, correctAnswer);
                return;
            }
        }

        printCongratulations();
    }

    protected abstract void printRules();

    protected abstract String generateQuestion();

    protected abstract String getCorrectAnswer();

    private void printQuestion(String numbers) {
        print("Question: " + numbers);
    }

    private String getUserAnswer() {
        print("Your answer: ");
        return inputScanner.nextLine().trim().toLowerCase();
    }

    private void printWrongAnswerMessage(String userAnswer,
                                         String correctAnswer) {
        printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, correctAnswer);
        printf("Let's try again, %s!%n", playerName);
    }

    private void printCongratulations() {
        printf("Congratulations, %s!%n", playerName);
    }
}
