package traffic;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    static Map<Integer, String> Menu = new LinkedHashMap<>();


    public static void main(String[] args) {
        initMenu();
        System.out.println("Welcome to the traffic management system!");
        printMenu();
    }

    private static void initMenu() {
        Menu.put(1, "Add");
        Menu.put(2, "Delete");
        Menu.put(3, "System");
        Menu.put(0, "Quit");
    }

    private static void printMenu() {
        System.out.println("Menu:");
        for (Map.Entry<Integer, String> entry : Menu.entrySet()) {
            System.out.printf("%d. %s%n", entry.getKey(), entry.getValue());
        }
    }


}
