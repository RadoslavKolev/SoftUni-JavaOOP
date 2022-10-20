package lection.validationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException(
                "First name cannot be less than 3 symbols"
            );
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException(
                "Last name cannot be less than 3 symbols"
            );
        }

        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(
                "Age cannot be zero or negative integer"
            );
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        if (salary < 460.0) {
            throw new IllegalArgumentException(
                "Salary cannot be less than 460 leva"
            );
        }

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
