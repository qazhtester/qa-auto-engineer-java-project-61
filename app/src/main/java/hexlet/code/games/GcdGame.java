package hexlet.code.games;

import java.util.List;

import static hexlet.code.RandomUtils.getRandomInt;

public final class GcdGame {
    public static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 2;
    private static final int MAX_DIVISOR_NUMBER = 15;
    private static final int MAX_NUMBER = 100;

    private GcdGame() {
    }

    public static List<String> getTask() {
        int baseDivisor = getRandomInt(MIN_NUMBER, MAX_DIVISOR_NUMBER);

        //Генерация двух чисел < 100, кратных baseDivisor
        int firstNumber = baseDivisor * getRandomInt(MIN_NUMBER, MAX_NUMBER / baseDivisor);
        int secondNumber = baseDivisor * getRandomInt(MIN_NUMBER, MAX_NUMBER / baseDivisor);

        String question = firstNumber + " " + secondNumber;
        String correctAnswer = String.valueOf(getGcd(firstNumber, secondNumber));
        return List.of(question, correctAnswer);
    }

    private static int getGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
