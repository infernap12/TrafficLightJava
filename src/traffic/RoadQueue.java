package traffic;

import java.util.LinkedList;


public class RoadQueue extends LinkedList<Road>{
        int frontIndex;

        public RoadQueue() {
                this.frontIndex = 0;

        }
    public void next() {
        frontIndex = (frontIndex + 1) % this.size();
    }
}

