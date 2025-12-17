package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;

public final class App {
    private static final int GREET = 1;
    private static final int GAME_EVEN = 2;
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
            startGame(userChoice, scanner, username);
        }
    }

    private static int selectGame(Scanner scanner) {
        print("""
                Please enter the game number and press Enter
                1 - Greet
                2 - Even
                0 - Exit
                Your choice:""");
        return Integer.parseInt(scanner.nextLine());
    }

    private static void startGame(int gameNumber, Scanner scanner, String username) {
        switch (gameNumber) {
            case GAME_EVEN -> new EvenGame(scanner, username).run();
            default -> throw new IllegalStateException("Unexpected value: " + gameNumber);
        }
    }
}
