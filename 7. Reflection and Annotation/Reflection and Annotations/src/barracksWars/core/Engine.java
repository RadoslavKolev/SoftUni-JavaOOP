package barracksWars.core;

import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {
	private final CommandInterpreter commandInterpreter;

	public Engine(CommandInterpreter commandInterpreter) {
		this.commandInterpreter = commandInterpreter;
	}

	@Override
	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final String END_CYCLE_COMMAND = "fight";
		String input;

		while (!(input = reader.readLine()).equals(END_CYCLE_COMMAND)) {
			try {
				final String[] data = input.split("\\s+");
				final String commandName = data[0];

				final Executable command = this.commandInterpreter.interpretCommand(data, commandName);

				System.out.println(command.execute());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
