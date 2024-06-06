package com.Task2;

public class Account {
    private double balance;

    // No-argument constructor
    public Account() {
        this.balance = 0;
    }

    // Parameterized constructor
    public Account(double balance) {
        this.balance = balance;
    }

    // Method to deposit the amount to the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Method to withdraw the amount from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdraw amount");
        }
    }

    // Method to display the balance
    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }

    // Main method for testing
    public static void main(String[] args) {
        Account acc1 = new Account();
        acc1.deposit(100);
        acc1.withdraw(50);
        acc1.displayBalance();

        Account acc2 = new Account(500);
        acc2.deposit(200);
        acc2.withdraw(100);
        acc2.displayBalance();
    }
}
