package com.Task2;

import java.util.Scanner;

public class ImplementProduct {
public static void main(String[]args) {
	Scanner sc=new Scanner(System.in);
	Product[] products = new Product[5];
	
	for(int i=0;i<5;i++) {
		 System.out.println("Enter product " + (i + 1) + " details (pid, price, quantity): ");
         int pid = sc.nextInt();
         double price = sc.nextDouble();
         int quantity = sc.nextInt();
         products[i] = new Product(pid, price, quantity);
	}
	  // Find Pid of the product with the highest price
    int highestPricePid = findHighestPricePid(products);
    System.out.println("Product with the highest price has PID: " + highestPricePid);

    // Calculate and display the total amount spent on all products
    double totalAmountSpent = calculateTotalAmountSpent(products);
    System.out.println("Total amount spent on all products: " + totalAmountSpent);
}

// Method to find PID of the product with the highest price
public static int findHighestPricePid(Product[] products) {
    double highestPrice = products[0].price;
    int highestPricePid = products[0].pid;
    for (Product product : products) {
        if (product.price > highestPrice) {
            highestPrice = product.price;
            highestPricePid = product.pid;
        }
    }
    return highestPricePid;
}

// Method to calculate total amount spent on all products
public static double calculateTotalAmountSpent(Product[] products) {
    double totalAmount = 0;
    for (Product product : products) {
        totalAmount += product.price * product.quantity;
    }
    return totalAmount;
   
}
}
