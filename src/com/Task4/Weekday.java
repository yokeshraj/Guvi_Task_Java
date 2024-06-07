package com.Task4;
import java.util.Scanner;

public class Weekday {
    public static void main(String[] args) {
        // Array storing names of weekdays
        String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            // Ask user for the day position
            System.out.println("Enter day position (0-6): ");
            int dayIndex = scanner.nextInt();

            try {
                // Print the day name based on user input
                System.out.println("Day is: " + weekdays[dayIndex]);
            } catch (ArrayIndexOutOfBoundsException e) {
                // Handle case where user input is out of valid range
                System.out.println("Invalid day index. Please enter a value between 0 and 6.");
            }

            // Ask the user if they want to continue
            System.out.println("Do you want to enter another day position? (yes/no): ");
            String userResponse = scanner.next();
            if (!userResponse.equalsIgnoreCase("yes")) {
                continueProgram = false;
            }
        }

        System.out.println("Program exited.");
        scanner.close();
    }
}
