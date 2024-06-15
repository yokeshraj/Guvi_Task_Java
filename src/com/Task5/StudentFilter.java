package com.Task5;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StudentFilter {

	    public static void main(String[] args) {
	        // Create a list of student names
	        List<String> studentNames = Arrays.asList("Alice", "Bob", "Annie", "John", "Andrew","alex","Jack","morgan","andrew","drake");

	        // Filter student names that start with "A"
	        List<String> filteredStudents = studentNames.stream()
	                                                    .filter(name -> name.startsWith("A")) // Keep names that start with "A"
	                                                    .collect(Collectors.toList()); // Collect the results into a new list

	        // Print each filtered student name
	        filteredStudents.forEach(System.out::println);
	    }
	}


