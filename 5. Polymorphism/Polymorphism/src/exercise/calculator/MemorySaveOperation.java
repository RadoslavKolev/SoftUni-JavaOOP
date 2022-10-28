package exercise.calculator;

import java.util.LinkedList;
import java.util.List;

public class MemorySaveOperation implements Operation{
    private List<Integer> operands;

    public MemorySaveOperation() {
        this.operands = new LinkedList<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);
    }

    @Override
    public int getResult() {
        return this.operands.get(operands.size() - 1);
    }

    @Override
    public boolean isCompleted() {
        return !this.operands.isEmpty();
    }

    public Integer releaseFromMemory() {
        return this.operands.remove(operands.size() - 1);
    }
}
