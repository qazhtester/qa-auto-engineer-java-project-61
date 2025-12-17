package hexlet.code;

import java.util.Random;

public final class RandomUtils {
    @SuppressWarnings("java:S2245")
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    /**
     * Генерирует случайное целое число в диапазоне от {@code min} до {@code max} включительно.
     *
     * @param min минимальное значение (включительно)
     * @param max максимальное значение (включительно)
     * @return случайное целое число в заданном диапазоне
     */
    public static int getRandomInt(int min, int max) {
        return RANDOM.nextInt(min, max + 1);
    }

    /**
     * Генерирует случайное целое число в диапазоне от 0 до {@code max} включительно.
     *
     * @param max максимальное значение (включительно)
     * @return случайное целое число в заданном диапазоне
     */
    public static int getRandomInt(int max) {
        return getRandomInt(0, max);
    }
}
