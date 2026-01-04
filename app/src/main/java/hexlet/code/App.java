package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

import static hexlet.code.ConsolePrinter.print;

public final class App {
    private static final int MENU_EXIT = 0;
    private static final int GREET = 1;
    private static final int GAME_EVEN = 2;
    private static final int GAME_CALC = 3;
    private static final int GAME_GCD = 4;
    private static final int GAME_PROGRESSION = 5;
    private static final int PRIME_GAME = 6;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int userChoice = selectGame(scanner);

            switch (userChoice) {
                case MENU_EXIT:
                    break;
                case GREET:
                    Cli.greetUser(scanner);
                    break;
                default:
                    String username = Cli.greetUser(scanner);
                    playGame(scanner, username, userChoice);
            }
        }
    }

    private static void playGame(Scanner scanner, String username, int userChoice) {
        switch (userChoice) {
            case GAME_EVEN -> EvenGame.run(scanner, username);
            case GAME_CALC -> CalcGame.run(scanner, username);
            case GAME_GCD -> GcdGame.run(scanner, username);
            case GAME_PROGRESSION -> ProgressionGame.run(scanner, username);
            case PRIME_GAME -> PrimeGame.run(scanner, username);
            default -> throw new IllegalStateException("Unexpected choice: " + userChoice);
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
