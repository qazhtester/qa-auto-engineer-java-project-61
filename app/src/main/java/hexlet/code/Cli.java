package hexlet.code;

import java.util.Scanner;

/**
 * Утилитарный класс для взаимодействия с пользователем
 * через командную строку (CLI).
 */
final class Cli {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Cli() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated"
        );
    }

    /**
     * Приветствует пользователя по имени
     * <p>
     * Метод выводит приглашение ввода, считывает введённое имя
     * и выводит персонализированное приветствие в консоль.
     * </p>
     */
    static void greetUser() {
        System.out.println("May I have your name?");
        String name = SCANNER.nextLine();
        System.out.printf("Hello, %s!%n", name);
    }
}
