package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.List;
import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;
import static hexlet.code.ConsolePrinter.printf;

public final class Engine {
    private static final int GAME_EVEN = 2;
    private static final int GAME_CALC = 3;
    private static final int GAME_GCD = 4;
    private static final int GAME_PROGRESSION = 5;
    private static final int PRIME_GAME = 6;
    private static final int ROUNDS_TO_WIN = 3;

    private Engine() {
    }

    public static void run(Scanner scanner,
                           String username,
                           int gameNumber) {
        printRules(getRules(gameNumber));

        for (int i = 0; i < ROUNDS_TO_WIN; i++) {
            List<String> task = getRoundTask(gameNumber);
            String question = task.getFirst();
            String correctAnswer = task.getLast();

            printQuestion(question);
            String userAnswer = getUserAnswer(scanner);

            if (!checkAnswer(correctAnswer, userAnswer, username)) {
                return;
            }
        }
        printCongratulations(username);
    }

    private static String getRules(int gameNumber) {
        return switch (gameNumber) {
            case GAME_EVEN -> EvenGame.RULES;
            case GAME_CALC -> CalcGame.RULES;
            case GAME_GCD -> GcdGame.RULES;
            case GAME_PROGRESSION -> ProgressionGame.RULES;
            case PRIME_GAME -> PrimeGame.RULES;
            default -> throw new IllegalArgumentException("Unknown game: " + gameNumber);
        };
    }

    private static List<String> getRoundTask(int gameNumber) {
        return switch (gameNumber) {
            case GAME_EVEN -> EvenGame.getTask();
            case GAME_CALC -> CalcGame.getTask();
            case GAME_GCD -> GcdGame.getTask();
            case GAME_PROGRESSION -> ProgressionGame.getTask();
            case PRIME_GAME -> PrimeGame.getTask();
            default -> throw new IllegalArgumentException("Unknown game: " + gameNumber);
        };
    }

    private static boolean checkAnswer(String correctAnswer, String userAnswer, String username) {
        if (correctAnswer.equals(userAnswer)) {
            print("Correct!");
            return true;
        } else {
            printWrongAnswerMessage(userAnswer, correctAnswer, username);
            return false;
        }
    }

    private static void printQuestion(String question) {
        print("Question: " + question);
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

    private static void printCongratulations(String username) {
        printf("Congratulations, %s!%n", username);
    }

    private static void printRules(String rules) {
        print(rules);
    }
}
