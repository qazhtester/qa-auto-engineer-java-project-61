package hexlet.code;

import java.util.Scanner;

final class Cli {

    private Cli() {
    }

    static String greetUser(Scanner scanner) {
        System.out.println("""
                Welcome to the Brain Games!
                May I have your name?""");
        String name = scanner.nextLine();
        System.out.printf("Hello, %s!%n", name);
        return name;
    }
}
