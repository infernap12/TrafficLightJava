package traffic;

public class inputManager extends com.infernap12.inputUtils.inputManager {


     int askInitials() {
         int output; //todo Find reasonable road,interval cut off, less than max int.
         while (true) {
             try {
                 output = requestIntRange(1,Integer.MAX_VALUE);
//                 logger.info(String.valueOf(output));
             } catch (Exception e) {
                 System.out.print("Error! Incorrect input. Try again.");
                 continue;
             }
             break;
         }
         return output;
    }

    String askLine() {
         String input = scanner.nextLine();
//        logger.info(input);
        return input;
    }
}
