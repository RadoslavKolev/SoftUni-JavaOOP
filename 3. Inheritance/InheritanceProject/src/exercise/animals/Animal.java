package exercise.animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    private void setName(String name) {
        validateString(name);
        this.name = name;
    }

    private void setAge(int age) {
        validateInt(age);
        this.age = age;
    }

    private void setGender(String gender) {
        validateString(gender);
        this.gender = gender;
    }

    private void validateString(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    private void validateInt(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                System.lineSeparator() +
                this.name + " " + this.age + " " + this.gender +
                System.lineSeparator() +
                produceSound();
    }

    public String produceSound() {
        return "";
    }
}
