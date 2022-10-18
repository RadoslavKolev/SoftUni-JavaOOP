package exercise.trafficLights;

public enum TrafficLights {
    RED("GREEN"), YELLOW("RED"), GREEN("YELLOW");

    private final String nextSignal;

    TrafficLights(String nextSignal) {
        this.nextSignal = nextSignal;
    }

    public String getNextSignal() {
        return nextSignal;
    }
}
