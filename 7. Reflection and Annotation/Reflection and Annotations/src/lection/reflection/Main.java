package lection.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Gets class information

//        Variant 1 - If we don't know the name at compile time (throws an error):
//        Class reflectionInfo = Class.forName("lection.Reflection");

//        Variant 2 - if we know the class name
        Class<Reflection> reflectionInfo = Reflection.class;
        System.out.println(reflectionInfo);

        // Gets the superclass info
//        Class<? super Reflection> reflectionSuperClassInfo = reflectionInfo.getSuperclass();
//        System.out.println(reflectionSuperClassInfo.toString());

        System.out.println(reflectionInfo.getSuperclass());

        // Gets the implemented interfaces:
        Class[] interfaces = reflectionInfo.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        // Instantiating an object:

        // Variant 1 - Deprecated since Java 9 (DON'T USE)
        // Object ref = reflectionInfo.newInstance();

        // Variant 2 - with "getDeclaredConstructor().newInstance()"
        Constructor<Reflection> reflectionConstructor = reflectionInfo.getDeclaredConstructor();
        Reflection reflection = reflectionConstructor.newInstance();
        System.out.println(reflection);
    }
}
