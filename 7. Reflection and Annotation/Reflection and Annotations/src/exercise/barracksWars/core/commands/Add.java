package exercise.barracksWars.core.commands;

import exercise.barracksWars.annotations.Inject;
import exercise.barracksWars.interfaces.Repository;
import exercise.barracksWars.interfaces.Unit;
import exercise.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command{
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute()
            throws ExecutionControl.NotImplementedException,
            ClassNotFoundException,
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        final String unitType = super.getData()[1];

        final Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);

        return unitType + " added!";
    }
}
