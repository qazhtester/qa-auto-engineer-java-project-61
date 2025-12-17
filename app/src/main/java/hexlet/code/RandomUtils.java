package hexlet.code;

import java.util.Random;

public final class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    /**
     * Генерирует случайное целое число
     * в диапазоне от  {@code min} до {@code max} <b>включительно</b>
     **/
    public static int getRandomInt(int min, int max) {
        return RANDOM.nextInt(min, max + 1);
    }

    /**
     * Генерирует случайное целое число
     * в диапазоне от 0 до {@code max} <b>включительно</b>
     **/
    public static int getRandomInt(int max) {
        return getRandomInt(0, max);
    }
}
