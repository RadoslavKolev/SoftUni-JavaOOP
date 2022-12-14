package exercise.barracksWars.core.commands;

import exercise.barracksWars.annotations.Inject;
import exercise.barracksWars.interfaces.Repository;

public class Report extends Command{
    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
