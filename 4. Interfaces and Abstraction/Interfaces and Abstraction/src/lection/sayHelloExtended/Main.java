package lection.sayHelloExtended;

import lection.sayHelloExtended.nationalities.Bulgarian;
import lection.sayHelloExtended.nationalities.Chinese;
import lection.sayHelloExtended.nationalities.European;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Bulgarian("Georgi"));
        persons.add(new European("Andrew"));
        persons.add(new Chinese("Wang"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}
