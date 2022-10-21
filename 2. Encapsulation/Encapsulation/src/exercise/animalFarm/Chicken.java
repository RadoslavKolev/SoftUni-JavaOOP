package exercise.animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        // First check if name is null, then call methods
        // Otherwise it will produce an error
        // isBlank() (Java 11) doesn't work on Judge (Java 8)
        // Replace with "name.trim().isEmpty()"
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.age < 6) {
            return 2.0;
        } else if (this.age < 12) {
            return 1.0;
        } else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Chicken %s (age %d) can produce %.2f eggs per day.",
            this.name, this.age, this.productPerDay()
        );

    }
}
