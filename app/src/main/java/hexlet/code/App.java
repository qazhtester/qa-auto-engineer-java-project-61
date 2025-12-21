package hexlet.code;

import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;

public final class App {
    private static final int GREET = 1;
    private static final int MENU_EXIT = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int userChoice = selectGame(scanner);

            if (userChoice == MENU_EXIT) {
                return;
            }

            if (userChoice == GREET) {
                Cli.greetUser(scanner);
                return;
            }

            String username = Cli.greetUser(scanner);
            Engine.run(scanner, username, userChoice);
        }
    }

    private static int selectGame(Scanner scanner) {
        print("""
                Please enter the game number and press Enter
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:""");
        return Integer.parseInt(scanner.nextLine());
    }
}
