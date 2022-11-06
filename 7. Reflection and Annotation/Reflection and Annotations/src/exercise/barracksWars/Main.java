package exercise.barracksWars;

import exercise.barracksWars.core.CommandInterpreterImpl;
import exercise.barracksWars.interfaces.CommandInterpreter;
import exercise.barracksWars.interfaces.Repository;
import exercise.barracksWars.interfaces.Runnable;
import exercise.barracksWars.interfaces.UnitFactory;
import exercise.barracksWars.core.Engine;
import exercise.barracksWars.core.factories.UnitFactoryImpl;
import exercise.barracksWars.data.UnitRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);
        Runnable engine = new Engine(commandInterpreter);

        try {
            engine.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
