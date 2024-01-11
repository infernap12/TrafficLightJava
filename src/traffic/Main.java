package traffic;

import java.io.Console;
import java.io.IOException;

public class Main {

    static Menu menu = new Menu();
    static inputManager input = new inputManager();
    static int roads;
    static int interval;

    static State state = State.NOT_STARTED;

    static RoadQueue queue = new RoadQueue();


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to the traffic management system!");
        System.out.print("Input the number of roads:");
        roads = input.askInitials();
        System.out.print("Input the interval:");
        interval = input.askInitials();

        state = State.MENU;

        Thread worker = new Thread(new TrafficRunner(roads,interval));
        worker.setName("QueueThread");
        worker.start();



        while (state == State.MENU) {
            menu.printOptions();
            String choice = input.askLine().trim();
            switch (choice) {
                case "1" -> {
                    System.out.print("Input road name: ");
                    String element = input.askLine();
                    if (queue.size() >= roads) {
                        System.out.println("Error: queue is full");
                    } else {
                        queue.add(new Road(element));
                        System.out.printf("%s Added.%n", element);
                    }
                }
                case "2" -> {
                    if (queue.isEmpty()) {
                        System.out.println("Error: queue is empty");
                    } else {
                        System.out.printf("%s deleted%n", queue.removeFirst().name);
                    }
                }
                case "3" -> state = State.SYSTEM;
                case "0" -> {
                    System.out.println("Bye!");
                    worker.interrupt();
                    worker.join();
                    System.exit(0);
                }
                default -> System.out.println("Incorrect option");
            }
            waitForEnter("");
            state = State.MENU;
            clear();

        }
    }

    static void clear() {
        try {
            var clearCommand = System.getProperty("os.name").contains("Windows")
                    ? new ProcessBuilder("cmd", "/c", "cls")
                    : new ProcessBuilder("clear");
            clearCommand.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ignored) {

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

            try {
                //noinspection ResultOfMethodCallIgnored
                System.in.read();
            } catch (Exception e) {
                System.out.printf("nope, we threw %s%n", e);
            }

        }
    }

    enum State {
        NOT_STARTED,
        MENU,
        SYSTEM
    }
}

