package com.Task4;

// Custom exception for invalid age for a voter
class InvalidAgeForVoterException extends Exception {
    // Adding serialVersionUID to the exception class
    private static final long serialVersionUID = 1L;

    public InvalidAgeForVoterException(String message) {
        super(message);
    }
}

// Voter class representing voter information
class Voter {
    private int voterId;
    private String name;
    private int age;

    // Parameterized constructor for initializing voter attributes
    public Voter(int voterId, String name, int age) throws InvalidAgeForVoterException {
        // Check if age is less than 18
        if (age < 18) {
            throw new InvalidAgeForVoterException("Invalid age for voter. Age must be 18 or above.");
        }
        this.voterId = voterId;
        this.name = name;
        this.age = age;
    }

    // Getters and setters for voter attributes
    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeForVoterException {
        // Check if age is less than 18
        if (age < 18) {
            throw new InvalidAgeForVoterException("Invalid age for voter. Age must be 18 or above.");
        }
        this.age = age;
    }

    public static void main(String[] args) {
        try {
            // Example of creating a voter with valid age
            Voter voter1 = new Voter(1, "John", 20);
            System.out.println("Voter created: " + voter1.getName() + ", Age: " + voter1.getAge() + ", Voter ID: " + voter1.getVoterId());

            // Example of creating a voter with invalid age
            Voter voter2 = new Voter(2, "Alice", 16);
        } catch (InvalidAgeForVoterException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Example of updating voter's age to a valid age
            Voter voter3 = new Voter(3, "Bob", 25);
            voter3.setAge(19);
            System.out.println("Updated Voter: " + voter3.getName() + ", Age: " + voter3.getAge() + ", Voter ID: " + voter3.getVoterId());

            // Example of updating voter's age to an invalid age
            voter3.setAge(17);
        } catch (InvalidAgeForVoterException e) {
            System.out.println(e.getMessage());
        }
    }
}
