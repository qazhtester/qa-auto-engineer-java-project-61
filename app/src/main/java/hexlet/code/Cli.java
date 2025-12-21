package hexlet.code;

import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;
import static hexlet.code.ConsolePrinter.printf;

final class Cli {

    private Cli() {
    }

    static String greetUser(Scanner scanner) {
        print("""
                Welcome to the Brain Games!
                May I have your name?""");
        String name = scanner.nextLine();
        printf("Hello, %s!%n", name);
        return name;
    }
}
