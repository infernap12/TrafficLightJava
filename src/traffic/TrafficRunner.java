package traffic;

public class TrafficRunner implements Runnable {
    RoadQueue queue;
    int interval;
    int roads;

    @Override
    public void run() {
        int roadTime = 0;
        int systemTime = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (roadTime % interval == 0 && !queue.isEmpty()) {
                    if (roadTime != 0) {
                        queue.next();
                    }
                    for (Road r : queue) {
                        if (queue.frontIndex == queue.indexOf(r)) {
                            r.state = Road.RoadState.OPEN;
                        } else {
                            r.state = Road.RoadState.CLOSED;
                        }
                    }
                }
                if (Main.state == Main.State.SYSTEM) {
                    Main.clear();

                    System.out.printf("! %ds. have passed since system startup !%n", systemTime);
                    System.out.printf("! Number of roads: %d !%n", roads);
                    System.out.printf("! Interval: %d !%n%n", interval);
                    for (Road r : queue) {
                        String name = r.name; // Road name
                        Road.RoadState state = r.state;
                        int time; // Time remaining

                        int index = queue.indexOf(r);
                        int front = queue.frontIndex;
                        int queueDepth = (queue.size() + index - front) % queue.size();
                        int timeUntilActive = queueDepth * interval;

                        if (state == Road.RoadState.OPEN) {
                            // For the currently open road, calculate the remaining time
                            time = interval - (roadTime % interval);
                        } else {
                            // For closed roads, calculate the time until they become active
                            int elapsedInCycle = roadTime % interval;
                            if (timeUntilActive >= elapsedInCycle) {
                                time = timeUntilActive - elapsedInCycle;
                            } else {
                                time = interval - elapsedInCycle + timeUntilActive;
                            }
                        }

                        System.out.printf("Road %s will be %s%s for %ds.\u001B[0m%n", name, state.colour, state.toString().toLowerCase(), time);
                    }

                    System.out.println("\n! Press \"Enter\" to open menu !");
                }
                if (!queue.isEmpty()) {
                    roadTime++;
                }
                systemTime++;
                Thread.sleep(1000L);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public TrafficRunner(int roads, int interval) {
        this.interval = interval;
        this.roads = roads;
        this.queue = Main.queue;
    }
}
