package barracksWars.data;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import jdk.jshell.spi.ExecutionControl;

import java.util.Map;
import java.util.TreeMap;

public class UnitRepository implements Repository {
	private final Map<String, Integer> amountOfUnits;

	public UnitRepository() {
		this.amountOfUnits = new TreeMap<>();
	}

	public void addUnit(Unit unit) {
		String unitType = unit.getClass().getSimpleName();

		this.amountOfUnits.putIfAbsent(unitType, 0);

		int newAmount = this.amountOfUnits.get(unitType) + 1;
		this.amountOfUnits.put(unitType, newAmount);
	}

	public String getStatistics() {
		StringBuilder statBuilder = new StringBuilder();

		for (var entry : amountOfUnits.entrySet()) {
			statBuilder.append(String.format(
					"%s -> %d%n",
					entry.getKey(), entry.getValue()
			));
		}

		statBuilder.setLength(statBuilder.length() - System.lineSeparator().length());
		return statBuilder.toString();
	}

	public void removeUnit(String unitType) throws ExecutionControl.NotImplementedException {
		// TODO: implement for problem 4
		throw new ExecutionControl.NotImplementedException("message");
	}
}