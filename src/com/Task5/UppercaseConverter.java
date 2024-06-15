package com.Task5;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseConverter {



	    public static void main(String[] args) {
	        // Create a list of strings
	        List<String> names = Arrays.asList("abc", "def", "ghi");

	        // Convert each string in the list to uppercase using the map method
	        List<String> uppercasedNames = names.stream()
	                                             .map(String::toUpperCase) // Convert each string to uppercase
	                                             .collect(Collectors.toList()); // Collect the results into a new list

	        // Print each uppercase string
	        uppercasedNames.forEach(System.out::println);
	    }
	}


