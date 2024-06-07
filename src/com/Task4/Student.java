package com.Task4;
// Custom exception for age not within the specified range
class AgeNotWithinRangeException extends Exception {
    // Adding serialVersionUID to the exception class
    private static final long serialVersionUID = 1L;

    public AgeNotWithinRangeException(String message) {
        super(message);
    }
}

// Custom exception for invalid name containing numbers or special symbols
class NameNotValidException extends Exception {
    // Adding serialVersionUID to the exception class
    private static final long serialVersionUID = 1L;
    public NameNotValidException(String message) {
        super(message);
    }
}

// Student class representing student information
class Student {
    private int rollNo;
    private String name;
    private int age;
    private String course;

    // Parameterized constructor for initializing student attributes
    public Student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException {
        // Check if age is within the range of 15 to 21
        if (age < 15 || age > 21) {
            throw new AgeNotWithinRangeException("Age is not within the range of 15 to 21.");
        }
        // Check if name contains only letters
        if (!name.matches("[a-zA-Z]+")) {
            throw new NameNotValidException("Name contains numbers or special symbols.");
        }
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters and setters for student attributes
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
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

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public static void main(String[] args) {
        try {
            // Example of creating a student with valid details
            Student student1 = new Student(1, "John", 18, "Computer Science");
            System.out.println("Student created: " + student1.getName() + ", Age: " + student1.getAge() + ", Course: " + student1.getCourse());

            // Example of creating a student with invalid age
            Student student2 = new Student(2, "Alice", 22, "Mathematics");
        } catch (AgeNotWithinRangeException | NameNotValidException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Example of creating a student with invalid name
            Student student3 = new Student(3, "Bob123", 19, "Physics");
        } catch (AgeNotWithinRangeException | NameNotValidException e) {
            System.out.println(e.getMessage());
        }
    }
}
