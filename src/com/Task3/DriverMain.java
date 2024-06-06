package com.Task3;

import java.util.Scanner;

public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept Employee Information
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        Employee employee = new Employee(empId, name, salary);

        // Accept Product Information
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();
        Product product = new Product(productId, price, quantity);

        // Calculate and Print Taxes
        double incomeTax = employee.calcTax();
        double salesTax = product.calcTax();

        System.out.println(employee);
        System.out.println("Income Tax: " + incomeTax);
        System.out.println(product);
        System.out.println("Sales Tax per unit: " + salesTax);

        scanner.close();
    }
}
