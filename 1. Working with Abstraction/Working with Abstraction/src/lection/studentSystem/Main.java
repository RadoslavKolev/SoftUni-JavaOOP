package lection.studentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        while (true) {
            String[] input = scanner.nextLine().split(" ");

            if (input[0].equals("Exit")) break;

            studentSystem.parseCommand(input);
        }
    }
}

/*
    Input:
    Create Peter 20 5.50
    Create Maria 18 4.50
    Create George 25 3
    Show Peter
    Show Maria
    Exit

    Output:
    Peter is 20 years old. Excellent student.
    Maria is 18 years old. Average student.
--------------------------------------------------
    Input:
    Create Teo 19 2.00
    Show Sam
    Show Teo
    Create Sam 20 3.00
    Show Teo
    Show Sam
    Exit


    Output:
    Teo is 19 years old. Very nice person.
    Teo is 19 years old. Very nice person.
    Sam is 20 years old. Very nice person.
 */
