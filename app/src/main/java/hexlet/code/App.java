package hexlet.code;

import java.util.Scanner;

public final class App {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int gameNumber = selectGame(scanner);
            if (gameNumber == 0) {
                return;
            }

            String username = Cli.greetUser(scanner);
            startGame(gameNumber, scanner, username);
        }
    }

    private static int selectGame(Scanner scanner) {
        System.out.println("""
                Please enter the game number and press Enter
                1 - Greet
                2 - Even
                0 - Exit""");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Your choice: " + number);
        return number;
    }

    private static void startGame(int gameNumber, Scanner scanner, String username) {
        if (gameNumber == 2) {
            EvenGame.run(scanner, username);
        }
    }
}
