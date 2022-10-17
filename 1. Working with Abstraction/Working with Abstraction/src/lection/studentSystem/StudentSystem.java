package lection.studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void parseCommand(String[] args) {
        String command = args[0];
        String name = args[1];

        switch (command) {
            case "Create":
                int age = Integer.parseInt(args[2]);
                double grade = Double.parseDouble(args[3]);
                registerStudent(name, age, grade);
                break;
            case "Show":
                String studentInfo = getStudentInfo(name);
                System.out.println(studentInfo);
                break;
            default:
                throw new IllegalArgumentException("Unknown command " + command);
        }
    }

    private void registerStudent(String name, int age, double grade) {
        this.students.putIfAbsent(name, new Student(name, age, grade));
    }

    private String getStudentInfo(String name) {
        Student student = this.students.get(name);
        String info = "";

        if (student != null) {
            info = formatStudent(student);
        }

        return info;
    }

    private static String formatStudent(Student student) {
        String output = String.format(
            "%s is %d years old. ",
            student.getName(), student.getAge()
        );

        output = validateGrade(student, output);

        return output;
    }

    private static String validateGrade(Student student, String output) {
        if (student.getGrade() >= 5.00) {
            output += "Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            output += "Average student.";
        } else {
            output += "Very nice person.";
        }

        return output;
    }
}
