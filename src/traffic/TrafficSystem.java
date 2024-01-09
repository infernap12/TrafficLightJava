package traffic;

import java.util.LinkedList;



public class TrafficSystem implements Runnable {
    LinkedList<String> queue;
    int interval;
    int roads;

    @Override
    public void run() {
        int elapsed = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {

                if (Main.state == Main.State.SYSTEM) {
                    Main.clear();

                    System.out.printf("! %ds. have passed since system startup !%n", elapsed);
                    System.out.printf("! Number of roads: %d !%n", roads);
                    System.out.printf("! Interval: %d !%n%n", interval);
                    for (String s : queue) {
                        System.out.println(s);
                    }
                    System.out.println("! Press \"Enter\" to open menu !");
                }

                elapsed++;
                Thread.sleep(1000L);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public TrafficSystem(int interval, int roads) {
        this.interval = interval;
        this.roads = roads;
        this.queue = Main.queue;
    }
}
