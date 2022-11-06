package barracksWars.core;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
	private final Repository repository;
	private final UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				String input = reader.readLine();

				String[] data = input.split("\\s+");
				String commandName = data[0];

				String result = interpretCommand(data, commandName);

				if (result.equals("fight")) break;

				System.out.println(result);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private String interpretCommand(String[] data, String commandName)
			throws ExecutionControl.NotImplementedException,
			ClassNotFoundException,
			InvocationTargetException,
			NoSuchMethodException,
			InstantiationException,
			IllegalAccessException {
		String result;

		switch (commandName) {
			case "add":
				result = this.addUnitCommand(data);
				break;
			case "report":
				result = this.reportCommand(data);
				break;
			case "fight":
				result = this.fightCommand(data);
				break;
			case "retire":
				result = this.removeUnitCommand(data);
				break;
			default:
				throw new RuntimeException("Invalid command!");
		}

		return result;
	}

	private String addUnitCommand(String[] data)
			throws ExecutionControl.NotImplementedException,
			ClassNotFoundException,
			InvocationTargetException,
			NoSuchMethodException,
			InstantiationException,
			IllegalAccessException {
		String unitType = data[1];
		Unit unitToAdd = this.unitFactory.createUnit(unitType);
		this.repository.addUnit(unitToAdd);
		return unitType + " added!";
	}

	private String reportCommand(String[] data) {
		return this.repository.getStatistics();
	}

	private String fightCommand(String[] data) {
		return "fight";
	}

	private String removeUnitCommand(String[] data)
			throws ExecutionControl.NotImplementedException {
		final String unitType = data[1];
		this.repository.removeUnit(unitType);
		return unitType + " retired!";
	}
}
