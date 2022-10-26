package exercise.militaryElite.military;

import exercise.militaryElite.military.interfaces.LieutenantGeneral;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private final List<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(PrivateImpl p) {
        this.privates.add(p);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(super.toString())
                .append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());

        // toList() doesn't work on Judge
        // use .collect(Collectors.toList())
        privates.stream()
                .sorted((soldier1, soldier2) -> Integer.compare(soldier2.getId(), soldier1.getId()))
                .toList()
                .forEach(soldier -> builder.append(String.format("  %s", soldier))
                                            .append(System.lineSeparator())
                );


        return builder.toString().trim();
    }
}
