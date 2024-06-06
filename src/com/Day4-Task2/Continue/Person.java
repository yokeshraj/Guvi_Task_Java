package com.Task2.Continue;
class Person {
    protected String name;
    protected int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display name and age
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Employee extends Person {
    private int employeeID;
    private double salary;

    // Constructor
    public Employee(String name, int age, int employeeID, double salary) {
        super(name, age); // Using super to initialize Person attributes
        this.employeeID = employeeID;
        this.salary = salary;
    }

    // Method to display employee details
    @Override
    public void display() {
        super.display();
        System.out.println("EmployeeID: " + employeeID + ", Salary: " + salary);
    }

    // Main method for testing
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 30, 101, 50000);
        emp.display();
    }
}
