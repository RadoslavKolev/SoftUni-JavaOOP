package lection.highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Field[] fields = Reflection.class.getDeclaredFields();
        Method[] methods = Reflection.class.getDeclaredMethods();

        checkFields(fields);
        checkGetters(methods);
        checkSetters(methods);
    }

    private static void checkFields(Field[] fields) {
        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted((Comparator.comparing(Field::getName)))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName())
        );
    }

    private static void checkGetters(Method[] methods) {
        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") &&
                        method.getParameterCount() == 0)
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be public!%n", method.getName())
        );
    }

    private static void checkSetters(Method[] methods) {
        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set") &&
                        method.getParameterCount() == 1)
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be private!%n", method.getName())
        );
    }
}
