package exercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchFieldException {
        // Gets information about BlackBoxInt class (Reflection)
        Class<BlackBoxInt> classInfo = BlackBoxInt.class;

        // Map that holds all the BlackBoxMethods, set to public
        // Initially they're private
        Map<String, Method> methodsMap = createMapWithMethods(classInfo);

        // Gets BlackBoxInt constructor set to public
        final Constructor<BlackBoxInt> blackBoxIntConstructor = getConstructor(classInfo);

        // Creates a BlackBoxInt instance, calling the constructor with 0 arguments
        final BlackBoxInt blackBoxInt = blackBoxIntConstructor.newInstance(0);

        executeCommands(methodsMap, blackBoxInt);
    }

    private static Map<String, Method> createMapWithMethods(Class<?> classInfo) {
        return Arrays.stream(classInfo.getDeclaredMethods())    // Gets all the BlackBoxInt methods
                .peek(method -> method.setAccessible(true))     // Sets all methods to public
                .collect(Collectors.toMap(Method::getName, method -> method));  // Collects them all to a map with relation String -> Method
    }

    private static Constructor<BlackBoxInt> getConstructor(Class<BlackBoxInt> classInfo)
            throws NoSuchMethodException {
        final Constructor<BlackBoxInt> blackBoxIntConstructor = classInfo.getDeclaredConstructor(int.class);
        blackBoxIntConstructor.setAccessible(true);
        return blackBoxIntConstructor;
    }

    private static void executeCommands(Map<String, Method> methodsMap, BlackBoxInt blackBoxInt)
            throws IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        final String FIELD_TO_PRINT = "innerValue";
        final String END_CYCLE_COMMAND = "END";

        String input = scanner.nextLine();

        while (!input.equals(END_CYCLE_COMMAND)) {
            final String[] tokens = input.split("_");
            final String methodName = tokens[0];
            final int value = Integer.parseInt(tokens[1]);

            // Invoking the current method
            invokeCurrentMethod(methodsMap, blackBoxInt, methodName, value);

            // Printing the current result on the console
            printCurrentValue(blackBoxInt, FIELD_TO_PRINT);

            input = scanner.nextLine();
        }

        scanner.close();
    }

    private static void invokeCurrentMethod(Map<String, Method> methodsMap, BlackBoxInt blackBoxInt, String methodName, int value)
            throws IllegalAccessException, InvocationTargetException {
        final Method currentMethod = methodsMap.get(methodName);    // Gets the current method from the map
        currentMethod.invoke(blackBoxInt, value);   // Invokes the method with the BlackBoxInt instance and the current value
    }

    private static void printCurrentValue(BlackBoxInt blackBoxInt, String field)
            throws NoSuchFieldException, IllegalAccessException {
        final Field result = blackBoxInt.getClass().getDeclaredField(field);     // Gets the specified field
        result.setAccessible(true);     // Sets its accessibility to public

        System.out.println(result.get(blackBoxInt));
    }
}
