package exercise.militaryElite.military.enums;

public enum State {
    IN_PROGRESS("inProgress"),
    FINISHED("finished");

    private final String name;

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
