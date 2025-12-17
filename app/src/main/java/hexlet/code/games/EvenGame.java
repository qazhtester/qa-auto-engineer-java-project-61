package hexlet.code.games;

import java.util.List;

import static hexlet.code.RandomUtils.getRandomInt;

public final class EvenGame {
    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final String IS_EVEN_ANSWER = "yes";
    private static final String NOT_EVEN_ANSWER = "no";

    private EvenGame() {
    }

    public static List<String> getTask() {
        int number = getRandomInt(MIN_NUMBER, MAX_NUMBER);
        String correctAnswer = getCorrectAnswer(number);
        return List.of(String.valueOf(number), correctAnswer);
    }

    private static String getCorrectAnswer(int number) {
        return number % 2 == 0 ? IS_EVEN_ANSWER : NOT_EVEN_ANSWER;
    }
}
