package com.Task5;
import java.util.Arrays;
import java.util.List;

public class NonEmptyStringCounter {

	
	    public static void main(String[] args) {
	        // Create a list of strings
	        List<String> strings = Arrays.asList("abc", "", "def", "ghi", "", "");

	        // Filter out non-empty strings and count them
	        long nonEmptyCount = strings.stream()
	                                    .filter(s -> !s.isEmpty()) // Filter out empty strings
	                                    .count(); // Count the remaining non-empty strings

	        // Print the total number of non-empty strings
	        System.out.println("Total non-empty strings: " + nonEmptyCount);
	    }
	}


