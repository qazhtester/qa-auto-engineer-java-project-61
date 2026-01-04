package hexlet.code;

import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;
import static hexlet.code.ConsolePrinter.printf;

public final class Engine {

    private Engine() {
    }

    public static void runGame(Scanner scanner,
                               String rules,
                               String username,
                               String[][] gameData) {
        print(rules);

        for (String[] roundData : gameData) {
            String question = roundData[0];
            String correctAnswer = roundData[1];

            print("Question: " + question);
            String userAnswer = getUserAnswer(scanner);

            if (correctAnswer.equals(userAnswer)) {
                print("Correct!");
            } else {
                printWrongAnswerMessage(userAnswer, correctAnswer, username);
                return;
            }
        }

        printCongratulations(username);
    }

    private static String getUserAnswer(Scanner scanner) {
        print("Your answer: ");
        return scanner.nextLine();
    }

    private static void printWrongAnswerMessage(String userAnswer,
                                                String correctAnswer,
                                                String username) {
        printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, correctAnswer);
        printf("Let's try again, %s!%n", username);
    }

    public static void printCongratulations(String username) {
        printf("Congratulations, %s!%n", username);
    }
}
