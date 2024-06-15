package com.Task5;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
public class AgeCalculator {
	

	
	    public static void main(String[] args) {
	        // Create a scanner to read input from the user
	        Scanner scanner = new Scanner(System.in);
	        String continueChoice;

	        do {
	            // Prompt the user to enter their birthdate
	            System.out.println("Enter your birthdate (yyyy-mm-dd):");
	            String input = scanner.nextLine();

	            // Parse the input string to a LocalDate object
	            LocalDate birthdate = LocalDate.parse(input);

	            // Get the current date
	            LocalDate today = LocalDate.now();

	            // Calculate the period between the birthdate and today
	            Period age = Period.between(birthdate, today);

	            // Print the calculated age in years, months, and days
	            System.out.println("Your age is: " + age.getYears() + " years, " 
	                               + age.getMonths() + " months, and " 
	                               + age.getDays() + " days.");

	            // Ask the user if they want to continue
	            System.out.println("Do you want to calculate another age? (yes/no):");
	            continueChoice = scanner.nextLine();
	        } while (continueChoice.equalsIgnoreCase("yes"));

	        // Close the scanner
	        scanner.close();
	    }
	}
	


