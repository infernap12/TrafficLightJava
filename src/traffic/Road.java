package traffic;

public class Road {
    RoadState state;
    String name;

    public Road(String name) {
        this.state = RoadState.CLOSED;
        this.name = name;
    }

    enum RoadState {
        OPEN, CLOSED
    }
}
