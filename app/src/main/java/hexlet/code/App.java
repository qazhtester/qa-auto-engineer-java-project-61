package hexlet.code;

public final class App {

    private App() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated"
        );
    }

    public static void main(final String[] args) {
        System.out.println("Welcome to the Brain Games!");
        Cli.greetUser();
    }
}
