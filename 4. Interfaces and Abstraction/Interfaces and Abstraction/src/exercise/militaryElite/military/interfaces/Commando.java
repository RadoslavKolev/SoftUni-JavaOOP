package exercise.militaryElite.military.interfaces;

import exercise.militaryElite.military.missions.MissionImpl;

import java.util.Collection;

public interface Commando {
    void addMission(MissionImpl mission);
    Collection<MissionImpl> getMissions();
}
