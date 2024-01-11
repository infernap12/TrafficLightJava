package traffic;

public class Road {
    RoadState state;
    String name;

    public Road(String name) {
        this.state = RoadState.CLOSED;
        this.name = name;
    }

    enum RoadState {
        OPEN("\u001B[32m"),
        CLOSED("\u001B[31m");
        final String colour;

        RoadState(String colour) {
            this.colour = colour;
        }
    }
}
