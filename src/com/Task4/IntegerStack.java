package com.Task4;
import java.util.Stack;

// Class to manage stack operations for integers
public class IntegerStack {
    // Stack to store integer elements
    private Stack<Integer> stack = new Stack<>();

    // Method to push an element onto the stack
    public void pushElement(int element) {
        stack.push(element);
    }

    // Method to pop an element from the stack
    public Integer popElement() {
        // Check if the stack is empty before attempting to pop
        if (!stack.isEmpty()) {
            // If the stack is not empty, pop the top element and return it
            return stack.pop();
        } else {
            // If the stack is empty, print a message and return null
            System.out.println("Stack is empty.");
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage of IntegerStack class
        IntegerStack intStack = new IntegerStack();
        
        // Push elements onto the stack
        intStack.pushElement(10);
        intStack.pushElement(20);

        // Pop elements from the stack and display them
        System.out.println("Popped element: " + intStack.popElement()); // Should pop 20
        System.out.println("Popped element: " + intStack.popElement()); // Should pop 10

        // Try to pop from an empty stack
        System.out.println("Popped element: " + intStack.popElement()); // Should print "Stack is empty." and return null
    }
}
