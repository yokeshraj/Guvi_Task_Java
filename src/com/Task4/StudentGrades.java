package com.Task4;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to manage student grades
public class StudentGrades {
    // HashMap to store student names (keys) and their grades (values)
    private Map<String, Integer> studentGrades = new HashMap<>();

    // Method to add a new student and their grade
    public void addStudent(String name, int grade) {
        studentGrades.put(name, grade);
        System.out.println("Added student: " + name + " with grade: " + grade);
    }

    // Method to remove a student by name
    public void removeStudent(String name) {
        if (studentGrades.containsKey(name)) {
            studentGrades.remove(name);
            System.out.println("Removed student: " + name);
        } else {
            System.out.println("Student not found: " + name);
        }
    }

    // Method to display a student's grade by name
    public void displayGrade(String name) {
        Integer grade = studentGrades.get(name);
        if (grade != null) {
            System.out.println(name + "'s grade: " + grade);
        } else {
            System.out.println("Student not found: " + name);
        }
    }

    public static void main(String[] args) {
        // Create an instance of StudentGrades
        StudentGrades sg = new StudentGrades();
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            // Display menu options
            System.out.println("Choose an option:");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Display a student's grade");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a student
                    System.out.print("Enter student name: ");
                    String nameToAdd = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    int gradeToAdd = scanner.nextInt();
                    sg.addStudent(nameToAdd, gradeToAdd);
                    break;
                case 2:
                    // Remove a student
                    System.out.print("Enter student name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    sg.removeStudent(nameToRemove);
                    break;
                case 3:
                    // Display a student's grade
                    System.out.print("Enter student name to display grade: ");
                    String nameToDisplay = scanner.nextLine();
                    sg.displayGrade(nameToDisplay);
                    break;
                case 4:
                    // Exit the program
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }

        System.out.println("Program exited.");
        scanner.close();
    }
}
