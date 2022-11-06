package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {
	private static final String UNITS_PACKAGE_NAME = "barracksWars.models.units.";

	@Override
	@SuppressWarnings("all")
	public Unit createUnit(String unitType) throws
			ExecutionControl.NotImplementedException,
			ClassNotFoundException,
			NoSuchMethodException,
			InvocationTargetException,
			InstantiationException,
			IllegalAccessException {
		final Class<Unit> unitClassInfo = (Class<Unit>) Class.forName(UNITS_PACKAGE_NAME + unitType);
		return createInstance(unitClassInfo);
	}

	private Unit createInstance(Class<Unit> unitClassInfo)
			throws NoSuchMethodException,
			InvocationTargetException,
			InstantiationException,
			IllegalAccessException {
		final Constructor<Unit> unitConstructor =
				unitClassInfo.getDeclaredConstructor();
		unitConstructor.setAccessible(true);	// Just in case

		return unitConstructor.newInstance();
	}
}
