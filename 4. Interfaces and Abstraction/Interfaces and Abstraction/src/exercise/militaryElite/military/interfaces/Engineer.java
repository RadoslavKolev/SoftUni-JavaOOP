package exercise.militaryElite.military.interfaces;

import exercise.militaryElite.military.repairs.Repair;

import java.util.Collection;

public interface Engineer {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}
