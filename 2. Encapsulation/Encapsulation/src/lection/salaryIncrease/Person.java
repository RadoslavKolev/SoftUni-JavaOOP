package lection.salaryIncrease;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary (double bonus) {
        double newSalary;

        if (this.age < 30) {
            // Half bonus
            newSalary = calcNewSalary(bonus, 200);
        } else {
            newSalary = calcNewSalary(bonus, 100);
        }

        this.setSalary(newSalary);
    }

    private double calcNewSalary(double bonus, int n) {
        return this.salary + (this.salary * bonus / n);
    }

    @Override
    public String toString() {
        return String.format(
            "%s %s gets %f leva.",
            this.firstName, this.lastName, this.salary
        );
    }
}
