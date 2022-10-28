package exercise.calculator;

public class AdvancedInputInterpreter extends InputInterpreter{
    private MemorySaveOperation memorySaveOperation;

    public AdvancedInputInterpreter(CalculationEngine engine) {
        super(engine);
    }

    @Override
    public Operation getOperation(String operation) {
        if (operation.equals("/")) {
            return new DivisionOperation();
        } else if (operation.equals("ms")) {
            if (this.memorySaveOperation == null) {
                this.memorySaveOperation = new MemorySaveOperation();
            }

            return this.memorySaveOperation;
        } else if (operation.equals("mr")) {
            return new MemoryRecallOperation(this.memorySaveOperation);
        }

        return super.getOperation(operation);
    }
}
