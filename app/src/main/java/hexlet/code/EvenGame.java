package hexlet.code;

import java.util.Random;
import java.util.Scanner;

final class EvenGame {
    private static final Random RANDOM = new Random();
    private static final int ROUNDS_TO_WIN = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private EvenGame() {
    }

    static void run(Scanner scanner, String username) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int correctAnswers = 0;

        while (correctAnswers < ROUNDS_TO_WIN) {
            int randomNumber = RANDOM.nextInt(MIN_NUMBER, MAX_NUMBER);
            System.out.println("Question: " + randomNumber);
            String userAnswer = getUserAnswer(scanner);
            String correctAnswer = isEven(randomNumber) ? "yes" : "no";

            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                printWrongAnswerMessage(userAnswer, correctAnswer, username);
                return;
            }
        }

        printCongratulations(username);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String getUserAnswer(Scanner scanner) {
        String answer = scanner.nextLine().trim().toLowerCase();
        System.out.println("Your answer: " + answer);
        return answer;
    }

    private static void printWrongAnswerMessage(final String userAnswer,
                                                final String correctAnswer,
                                                final String username) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n",
                userAnswer, correctAnswer).printf("Let's try again, %s!%n", username);
    }

    private static void printCongratulations(String username) {
        System.out.printf("Congratulations, %s!%n", username);
    }
}
