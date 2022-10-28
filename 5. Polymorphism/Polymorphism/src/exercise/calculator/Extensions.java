package exercise.calculator;

public class Extensions {
    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new AdvancedInputInterpreter(engine);
    }
}
