package traffic;


import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    Map<Integer, String> menu;

    public Menu() {
        this.menu = new LinkedHashMap<>();
    }

    void printOptions() {
        System.out.println("Menu:");
        for (mainMenu value : mainMenu.values()) {
            System.out.printf("%d. %s%n", value.index,value.option);
        }
    }


    enum mainMenu {

        ADD(1, "Add road"),
        DELETE(2, "Delete road"),
        SYSTEM(3, "Open system"),
        QUIT(0, "Quit");
        final int index;
        final String option;

        mainMenu(int index, String option) {
            this.index = index;
            this.option = option;
        }
    }

}