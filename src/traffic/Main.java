package traffic;

import java.io.Console;
import java.io.IOException;

public class Main {

    static Menu menu = new Menu();
    static inputManager input = new inputManager();
    static int roads;
    static int interval;


    public static void main(String[] args) {
        System.out.println("Welcome to the traffic management system!");
        System.out.print("Input the number of roads:");
        roads = input.askInitials();
        System.out.print("Input the interval:");
        interval = input.askInitials();
        while (true) {
            menu.printOptions();
            String choice = input.askLine().trim();
            switch (choice) {
                case "1" -> System.out.println("Road added");
                case "2" -> System.out.println("Road deleted");
                case "3" -> System.out.println("System opened");
                case "0" -> {
                    System.out.println("Bye!");
                    System.exit(0);
                }
                default -> System.out.println("Incorrect option");
            }
            waitForEnter("");
            try {
                var clearCommand = System.getProperty("os.name").contains("Windows")
                        ? new ProcessBuilder("cmd", "/c", "cls")
                        : new ProcessBuilder("clear");
                clearCommand.inheritIO().start().waitFor();
            }
            catch (IOException | InterruptedException ignored) {

            }

        }

    }

    // ...
    public static void waitForEnter(String message, Object... args) {
        Console c = System.console();
        if (c != null) {
            // printf-like arguments
            if (message != null)
                c.format(message, args);
            c.format("\nPress ENTER to proceed.\n");
            c.readLine();
        } else {

            try{
                //noinspection ResultOfMethodCallIgnored
                System.in.read();}
            catch(Exception e){
                System.out.printf("nope, we threw %s%n", e);
            }

        }
    }
}

