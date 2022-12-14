package lection.sortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>(n);

        fillPeople(reader, n, people);

        people.sort(Comparator
                .comparing(Person::getFirstName)
                .thenComparingInt(Person::getAge)
        );

        for (Person person : people) {
            System.out.println(person);
        }
    }

    private static void fillPeople(BufferedReader reader, int n, List<Person> people) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            people.add(new Person(firstName, lastName, age));
        }
    }
}
