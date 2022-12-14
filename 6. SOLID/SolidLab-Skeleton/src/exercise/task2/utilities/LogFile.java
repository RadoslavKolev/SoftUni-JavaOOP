package exercise.task2.utilities;

public class LogFile implements File{
    private final StringBuilder memory;

    public LogFile() {
        this.memory = new StringBuilder();
    }

    @Override
    public void write(String line) {
        memory.append(line)
              .append(System.lineSeparator());
    }

    @Override
    public int size() {
        return this.memory
                .chars()
                .filter(Character::isAlphabetic)
                .sum();
    }
}
