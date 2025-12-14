package hexlet.code;

import java.util.Scanner;

final class Cli {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Cli() {
    }

    static void greetUser() {
        System.out.println("May I have your name?");
        String name = SCANNER.nextLine();
        System.out.printf("Hello, %s!%n", name);
    }
}
