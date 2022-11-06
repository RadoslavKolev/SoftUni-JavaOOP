package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command{
    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute()
            throws ExecutionControl.NotImplementedException {
        final String unitType = super.getData()[1];
        this.repository.removeUnit(unitType);
        return unitType + " retired!";
    }
}
