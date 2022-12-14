package exercise.militaryElite.military.repairs;

public class Repair {
    private final String partName;
    private final int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format(
            "Part Name: %s Hours Worked: %d",
            this.partName, this.hoursWorked
        );
    }
}
