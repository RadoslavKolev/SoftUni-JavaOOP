package exercise.militaryElite.military.missions;

import exercise.militaryElite.military.enums.State;

public class MissionImpl implements Mission {
    private final String codeName;
    private State state;

    public MissionImpl(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public void completeMission() {
        this.state = State.FINISHED;
    }

    @Override
    public String toString() {
        return String.format(
            "Code Name: %s State: %s",
            this.codeName, this.state.getName()
        );
    }
}
