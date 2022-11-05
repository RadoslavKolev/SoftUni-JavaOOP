package lection.codingTracker;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Tracker {
    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> classInfo) {
        Map<String, String> methodsByAuthor = new HashMap<>();
        fillMap(classInfo, methodsByAuthor);
        printMapElements(methodsByAuthor);
    }

    private static void fillMap(Class<?> classInfo, Map<String, String> methodsByAuthor) {
        Method[] methods = classInfo.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);

            if (annotation == null) continue;

            String annotationName = annotation.name();
            String methodName = method.getName() + "()";

            methodsByAuthor.putIfAbsent(annotationName, methodName);
        }
    }

    @Author(name = "Diego")
    private static void printMapElements(Map<String, String> methodsByAuthor) {
        for (var entry : methodsByAuthor.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
