package exercise.militaryElite.military;

import exercise.militaryElite.military.enums.Corps;
import exercise.militaryElite.military.interfaces.Commando;
import exercise.militaryElite.military.missions.MissionImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private final List<MissionImpl> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(MissionImpl mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<MissionImpl> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(super.toString())
                .append(System.lineSeparator())
                .append("Missions:")
                .append(System.lineSeparator());

        for (MissionImpl mission : missions) {
            builder.append(String.format("  %s", mission))
                    .append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
