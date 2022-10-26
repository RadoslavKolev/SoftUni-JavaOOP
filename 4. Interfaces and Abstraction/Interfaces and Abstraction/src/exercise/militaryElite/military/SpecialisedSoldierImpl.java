package exercise.militaryElite.military;

import exercise.militaryElite.military.enums.Corps;

public abstract class SpecialisedSoldierImpl extends PrivateImpl{
    private final Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String toString() {
        return super.toString() +
                System.lineSeparator() +
                "Corps: " +
                this.corps.getName();
    }
}
