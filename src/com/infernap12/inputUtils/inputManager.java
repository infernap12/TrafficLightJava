package com.infernap12.inputUtils;

import java.util.Scanner;
import java.util.logging.Logger;

public class inputManager {
    protected Logger logger;
    protected Scanner scanner;

    public inputManager() {
        this.logger = Logger.getLogger(this.getClass().getName());
        this.scanner = new Scanner(System.in);
    }

    protected int requestIntRange(int min, int max) {
        int intput;
        String input = scanner.nextLine();
        intput = Integer.parseInt(input);
        if (!(intput >= min && intput <= max)){
            throw new NumberFormatException();
        }
        return intput;

    }
}
