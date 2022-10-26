package exercise.militaryElite.military;

import exercise.militaryElite.military.enums.Corps;
import exercise.militaryElite.military.interfaces.Engineer;
import exercise.militaryElite.military.repairs.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private final List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(super.toString())
                .append(System.lineSeparator())
                .append("Repairs:")
                .append(System.lineSeparator());

        for (Repair repair : repairs) {
            builder.append(String.format("  %s", repair))
                    .append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
